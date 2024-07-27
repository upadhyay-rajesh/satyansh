package com.fullstackglobalservlet.service;

import com.facebookwebsatyansh.dao.FacebookDAO;
import com.facebookwebsatyansh.dao.FacebookDAOInterface;
import com.fullstackglobalservlet.entity.MyEntity;

public class MyProjectService implements MyProjectServiceInterface {

	@Override
	public int createProfileService(MyEntity m) {
		FacebookDAOInterface fdao=new FacebookDAO();
		int i=fdao.createProfileDAO(m);
		return i;
	}

	@Override
	public boolean loginProfileService(MyEntity m) {
		FacebookDAOInterface fdao=new FacebookDAO();
		boolean i=fdao.loginProfileDAO(m);
		return i;
	}

	@Override
	public MyEntity viewProfileService(MyEntity fuser) {
		FacebookDAOInterface fdao=new FacebookDAO();
		return fdao.viewProfileDAO(fuser);
	}

}
