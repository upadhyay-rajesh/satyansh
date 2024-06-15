package com.facebooksatyansh;

import java.util.Scanner;

import com.facebooksatyansh.controller.FacebookController;
import com.facebooksatyansh.controller.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args) {
		String ss="y";
		
		//equals method is use to compare 2 object
		
		while(ss.equals("y")) {
			System.out.println("**********************MAIN MENU************");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to edit profile");
			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to search profile");
			System.out.println("press 6 to login profile");
			System.out.println("press 7 to view all profile");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			
			FacebookControllerInterface fc=new FacebookController();
			
			
			switch(choice) {
			case 1 : fc.createProfileController();
				break;
			case 2 :fc.viewProfileController();
				break;
			case 3 :fc.editProfileController();
				break;
			case 4 :fc.deleteProfileController();
				break;
			case 5 :fc.searchProfileController();
				break;
			case 6 :fc.loginProfileController();
				break;
			case 7 :fc.viewAllProfileController();
				break;
				default : System.out.println("wrong choice");
			}
			System.out.println("do you want to continue press y");
			ss=sc.next();
		}

	}

}
