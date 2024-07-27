package com.facebookwebsatyansh.dao;

import com.fullstackglobalservlet.entity.MyEntity;

public interface FacebookDAOInterface {

	int createProfileDAO(MyEntity fuser);

	boolean loginProfileDAO(MyEntity fuser);

	MyEntity viewProfileDAO(MyEntity fuser);

}
