package com.facebookwebsatyansh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fullstackglobalservlet.entity.MyEntity;

public class FacebookDAO implements FacebookDAOInterface {

	@Override
	public int createProfileDAO(MyEntity fuser) {
		int i=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyanshdatabase","root","root");
			
			String name=fuser.getFirstName()+" "+fuser.getLastName();
			
			PreparedStatement ps=con.prepareStatement("insert into myentity values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, fuser.getPassword());
			ps.setString(3, fuser.getEmail());
			ps.setString(4, fuser.getAddress() );
			
			
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean loginProfileDAO(MyEntity fuser) {
		boolean ff=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyanshdatabase","root","root");
			
			System.out.println(fuser.getEmail()+fuser.getPassword());
			
			PreparedStatement ps=con.prepareStatement("select * from myentity where email=? and password=?");
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

	@Override
	public MyEntity viewProfileDAO(MyEntity fuser) {
		MyEntity ff=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/satyanshdatabase","root","root");
			PreparedStatement ps=con.prepareStatement("select * from myentity where email=?");
			ps.setString(1, fuser.getEmail());
			
			 ResultSet res= ps.executeQuery();
			 if(res.next()) {
				 String n=res.getString(1);
				 String p=res.getString(2);
				 String e=res.getString(3);
				 String a=res.getString(4);
				 
				 ff=new MyEntity();
				 ff.setFirstName(n);
				 ff.setPassword(p);
				 ff.setEmail(e);
				 ff.setAddress(a);
				 
			 }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return ff;
	}

}
