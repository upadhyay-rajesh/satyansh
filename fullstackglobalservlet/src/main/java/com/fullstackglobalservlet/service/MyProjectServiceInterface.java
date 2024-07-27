package com.fullstackglobalservlet.service;

import com.fullstackglobalservlet.entity.MyEntity;

public interface MyProjectServiceInterface {

	int createProfileService(MyEntity m);

	boolean loginProfileService(MyEntity m);

	MyEntity viewProfileService(MyEntity fuser);

}
