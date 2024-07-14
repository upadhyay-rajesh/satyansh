package com.facebooksatyansh.controller;

import java.util.List;
import java.util.Scanner;

import com.facebooksatyansh.entity.FacebookUser;
import com.facebooksatyansh.exception.ProfileNotFoundException;
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
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to see profile");
		String email=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		
		FacebookServiceInterface fService=new FacebookService();
		FacebookUser f1=fService.viewProfileService(fuser);
		try {
		if(f1!=null) {
			System.out.println("Your profile is ");
			System.out.println("Name is --> "+f1.getName());
			System.out.println("Password is --> "+f1.getPassword());
			System.out.println("Email is --> "+f1.getEmail());
			System.out.println("Address is --> "+f1.getAddress());
		}
		else {
			throw new ProfileNotFoundException("profile with given email "+email+" not available in database");
		}
		}
		catch(ProfileNotFoundException f) {
			System.out.println(f);
		}

	}

	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to see delete profile");
		String email=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		
		FacebookServiceInterface fService=new FacebookService();
		int f1=fService.deleteProfileService(fuser);
		if(f1>0) {
			System.out.println("profile deleted");
		}
		else {
			System.out.println("could not delete profile");
		}
	}

	public void editProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to edit profile");
		String email=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		
		FacebookServiceInterface fService=new FacebookService();
		FacebookUser f1=fService.viewProfileService(fuser);
		
		if(f1!=null) {
			System.out.println("Your old profile is ");
			System.out.println("Name is --> "+f1.getName());
			System.out.println("Password is --> "+f1.getPassword());
			System.out.println("Email is --> "+f1.getEmail());
			System.out.println("Address is --> "+f1.getAddress());
			
			System.out.println("press 1 to edit password");
			System.out.println("press 2 to edit address");
			int c=sc.nextInt();
			 FacebookUser f2=new FacebookUser();
			switch(c) {
			case 1 : System.out.println("enter new password");
					 String password=sc.next();
					 f2.setPassword(password);
					 f2.setEmail(email);
					// FacebookServiceInterface fService=new FacebookService();
					 int f3=fService.editProfileService(f2);
					 if(f3>0) {
							System.out.println("password  updated");
						}
						else {
							System.out.println("could not edit password");
						}
				break;
			case 2 : System.out.println("enter new address");
					 String address=sc.next();
					 f2.setAddress(address);
					 f2.setEmail(email);
					 int f4=fService.editProfileService(f2);
					 if(f4>0) {
							System.out.println("address edited");
						}
						else {
							System.out.println("could not edit address");
						}
				break;
				default : System.out.println("wrong choice");
			}
		}
		else {
			System.out.println("profile not found for given mail id "+email);
		}


	}

	public void viewAllProfileController() {
		FacebookServiceInterface fService=new FacebookService();
		List<FacebookUser> flist= fService.viewAllProfileService();
		
		for(FacebookUser f1:flist) {
			System.out.println("***********************************");
			System.out.println("Your profile is ");
			System.out.println("Name is --> "+f1.getName());
			System.out.println("Password is --> "+f1.getPassword());
			System.out.println("Email is --> "+f1.getEmail());
			System.out.println("Address is --> "+f1.getAddress());
			
		}
	}

	public void loginProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to login profile");
		String email=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		fuser.setPassword(password);
		
		
		FacebookServiceInterface fService=new FacebookService();
		boolean f1=fService.loginProfileService(fuser);
		
		if(f1) {
			System.out.println("YWelcome to portal Mr./Mrs. "+email);
			
		}
		else {
			System.out.println("Invalid id and password");
		}

	}

	public void searchProfileController() {
		// TODO Auto-generated method stub

	}

}
