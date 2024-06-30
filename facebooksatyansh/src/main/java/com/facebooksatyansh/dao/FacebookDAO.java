package com.facebooksatyansh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facebooksatyansh.entity.FacebookUser;
import com.facebooksatyansh.utility.DatabaseConnection;
//DAO(DATA ACCESS OBJECT) layer is use to interact with database
//here we will use JDBC(java database connectivity) to connect with mysql database
public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fuser) {
		//here we want to use mysql database
		//jdbc have 5 steps
		int i=0;
		try {
			//step 1 load driver
			Class.forName("com.mysql.jdbc.Driver");
			//where is the above driver? it is inside mysql jar file. how to get that jar file? add dependency inside pom.xml file
			//which exception Class.forName() can create ClassNotFoundException
			//all the supporting inbuild classes and interfaces for jdbc is available inside java.sql package
			
			//step 2 create connection with database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyanshdatabase","root","root");
			//step 2 end
			
			//step 3 create dynamic query using PreparedStatement
			PreparedStatement ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
			ps.setString(1, fuser.getName());
			ps.setString(2, fuser.getPassword());
			ps.setString(3, fuser.getEmail());
			ps.setString(4, fuser.getAddress() );
			
			//is there any other way to create query? yes we have Statement interface to create static query
			//step 3 end
			//step 4 how to execute query
			//for insert, delete, update query we will use executeUpdate(); and it will return integer this integer value means no of rows affected by query
			//for select query we will use executeQuery() method and it return type will be ResultSet
			
			i=ps.executeUpdate();
			//step 4 end
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FacebookUser viewProfileDAO(FacebookUser fuser) {
		FacebookUser ff=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fuser.getEmail());
			
			 ResultSet res= ps.executeQuery();
			 if(res.next()) {
				 String n=res.getString(1);
				 String p=res.getString(2);
				 String e=res.getString(3);
				 String a=res.getString(4);
				 
				 ff=new FacebookUser();
				 ff.setName(n);
				 ff.setPassword(p);
				 ff.setEmail(e);
				 ff.setAddress(a);
				 
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

	public boolean loginProfileDAO(FacebookUser fuser) {
		boolean ff=false;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? and password=?");
			ps.setString(1, fuser.getEmail());
			ps.setString(2, fuser.getPassword());
			
			 ResultSet res= ps.executeQuery();
			 if(res.next()) {
				 ff=true;
				 
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

	public List<FacebookUser> viewAllProfileDAO() {
		List<FacebookUser> ff1=new ArrayList<FacebookUser>();
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from facebookuser");
			
			
			 ResultSet res= ps.executeQuery();
			 while(res.next()) {
				 String n=res.getString(1);
				 String p=res.getString(2);
				 String e=res.getString(3);
				 String a=res.getString(4);
				 
				 FacebookUser ff=new FacebookUser();
				 ff.setName(n);
				 ff.setPassword(p);
				 ff.setEmail(e);
				 ff.setAddress(a);
				 
				 ff1.add(ff);
				 
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff1;
	}

}
