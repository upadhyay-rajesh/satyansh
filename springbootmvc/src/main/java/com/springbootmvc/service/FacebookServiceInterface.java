package com.springbootmvc.service;

import java.util.List;

import com.springbootmvc.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfile(FacebookUser fb);

	int loginProfile(FacebookUser fb);

	List<FacebookUser> viewProfile(FacebookUser fb);

	List<FacebookUser> viewallProfile();

	List<FacebookUser> searchProfile(String option,String value1);

	int editProfile(FacebookUser fb);

	int deleteProfile(FacebookUser fb);

}
