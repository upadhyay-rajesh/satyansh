package com.springbootmvc.service;

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

}
