package com.springbootmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootmvc.entity.FacebookUser;

import jakarta.persistence.EntityTransaction;


@Repository
public class FacebookDAO implements FacebookDAOInterface {
	@Autowired
	private SessionFactory sf; //SessionFactory sf=new Configuration().configure().buildSessionFactory();

	@Override
	//@Transactional
	//@Modifying
	public int createProfileDAO(FacebookUser fb) {
		Session ss=sf.openSession();
		ss.save(fb);
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		et.commit();
		return 1;
	}

}
