package com.facebooksatyansh.exception;

public class ProfileNotFoundException extends Exception {
	String str;
	public ProfileNotFoundException(String str) {
		this.str=str;
	}
	
	public String toString() {
		return str;
	}
}
