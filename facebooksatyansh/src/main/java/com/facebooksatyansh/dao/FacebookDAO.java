package com.facebooksatyansh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.facebooksatyansh.entity.FacebookUser;
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

}
