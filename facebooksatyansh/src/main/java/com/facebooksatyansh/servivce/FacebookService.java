package com.facebooksatyansh.servivce;

import com.facebooksatyansh.dao.FacebookDAO;
import com.facebooksatyansh.dao.FacebookDAOInterface;
import com.facebooksatyansh.entity.FacebookUser;

//why service layer?
//to write all business logic like data validation, security
public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fuser) {
		//step 1 write business logic if required start
		//step 1 end
		//step 2 transfer object which service layer have taken from controller ex fuser in this example start
		FacebookDAOInterface fdao=new FacebookDAO();
		int i=fdao.createProfileDAO(fuser);
		//step 2 end
		//step 3 return dao result to controller start
		return i;
		//step 3 end
	}

}