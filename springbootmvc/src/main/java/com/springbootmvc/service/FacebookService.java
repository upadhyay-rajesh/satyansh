package com.springbootmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmvc.dao.FacebookDAO;
import com.springbootmvc.dao.FacebookDAOInterface;
import com.springbootmvc.entity.FacebookUser;

@Service
public class FacebookService implements FacebookServiceInterface {
	
	@Autowired
	private FacebookDAOInterface fd;  //FacebookDAOInterface fd=new FacebookDAO();

	@Override
	public int createProfile(FacebookUser fb) {
		
		return fd.createProfileDAO(fb);
	}

	@Override
	public int loginProfile(FacebookUser fb) {
		// TODO Auto-generated method stub
		return fd.loginProfileDAO(fb);
	}

	@Override
	public List<FacebookUser> viewProfile(FacebookUser fb) {
		// TODO Auto-generated method stub
		return fd.viewProfileDAO(fb);
	}

	@Override
	public List<FacebookUser> viewallProfile() {
		return fd.viewallProfileDAO();
	}

	@Override
	public List<FacebookUser> searchProfile(String option,String value1) {
		return fd.searchProfileDAO(option,value1);
	}

	@Override
	public int editProfile(FacebookUser fb) {
		return fd.editProfileDAO(fb);
	}

	@Override
	public int deleteProfile(FacebookUser fb) {
		return fd.deleteProfileDAO(fb);
	}

}
