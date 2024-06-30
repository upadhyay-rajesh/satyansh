package com.facebooksatyansh.servivce;

import java.util.List;

import com.facebooksatyansh.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fuser);

	FacebookUser viewProfileService(FacebookUser fuser);

	boolean loginProfileService(FacebookUser fuser);

	List<FacebookUser> viewAllProfileService();

}
