package com.facebooksatyansh.dao;

import java.util.List;

import com.facebooksatyansh.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fuser);

	FacebookUser viewProfileDAO(FacebookUser fuser);

	boolean loginProfileDAO(FacebookUser fuser);

	List<FacebookUser> viewAllProfileDAO();

	int deleteProfileDAO(FacebookUser fuser);

	int editProfileDAO(FacebookUser f2);

}
