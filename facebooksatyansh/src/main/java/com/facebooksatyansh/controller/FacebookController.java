package com.facebooksatyansh.controller;

import java.util.Scanner;

import com.facebooksatyansh.entity.FacebookUser;
import com.facebooksatyansh.servivce.FacebookService;
import com.facebooksatyansh.servivce.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface {

	public void createProfileController() {
		//step 1 take data from user if required start
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password =sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		
		//step 1 end
		
		//step 2 store data into object start
		
		//we will transfer data from one layer to other layer using DTO (DATA TRANSFER OBJECT) design pattern
		//which class object? entity class object
		
		FacebookUser fuser=new FacebookUser();
		fuser.setName(name);
		fuser.setPassword(password);
		fuser.setEmail(email);
		fuser.setAddress(address);
		//step 2 end
		//step 3 transfer the above entity class object to service layer start
		
		FacebookServiceInterface fservice=new FacebookService();
		int i=fservice.createProfileService(fuser);
		
		//step 3 end
		//step 4 ther result return by service will evaluate and based on that controller will return result to view start
		
		if(i>0) {
			System.out.println("Profile created");
		}
		else {
			System.out.println("could not create profile");
		}
		//step 4 end
		

	}

	public void viewProfileController() {
		// TODO Auto-generated method stub

	}

	public void deleteProfileController() {
		// TODO Auto-generated method stub

	}

	public void editProfileController() {
		// TODO Auto-generated method stub

	}

	public void viewAllProfileController() {
		// TODO Auto-generated method stub

	}

	public void loginProfileController() {
		// TODO Auto-generated method stub

	}

	public void searchProfileController() {
		// TODO Auto-generated method stub

	}

}
