package com.springbootmvc.dao;

import java.util.List;

import com.springbootmvc.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	int loginProfileDAO(FacebookUser fb);

	List<FacebookUser> viewProfileDAO(FacebookUser fb);

	List<FacebookUser> viewallProfileDAO();

	List<FacebookUser> searchProfileDAO(String option,String value1);

	int editProfileDAO(FacebookUser fb);

	int deleteProfileDAO(FacebookUser fb);

}
