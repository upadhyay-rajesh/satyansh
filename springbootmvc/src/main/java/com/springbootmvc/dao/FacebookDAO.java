package com.springbootmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootmvc.entity.FacebookUser;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;


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

	@Override
	public int loginProfileDAO(FacebookUser fb) {
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.springbootmvc.entity.FacebookUser f where f.email=:em and f.password=:pwd");
		q.setParameter("em", fb.getEmail());
		q.setParameter("pwd", fb.getPassword());
		
		List<FacebookUser> ff= q.getResultList();
		if(ff.size()>0) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public List<FacebookUser> viewProfileDAO(FacebookUser fb) {
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.springbootmvc.entity.FacebookUser f where f.email=:em");
		q.setParameter("em", fb.getEmail());
		List<FacebookUser> ff= q.getResultList();
		return ff;
	}

	@Override
	public List<FacebookUser> viewallProfileDAO() {
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.springbootmvc.entity.FacebookUser f");
		List<FacebookUser> ff= q.getResultList();
		return ff;
	}

	@Override
	public List<FacebookUser> searchProfileDAO(String option,String value1) {
		Session ss=sf.openSession();
		System.out.println(option+"  "+value1);
		Query q=null;
		if(option.equals("name")) {
			q=ss.createQuery("from com.springbootmvc.entity.FacebookUser f where f.name=:p");
			q.setParameter("p", value1);
		}
		if(option.equals("email")) {
			q=ss.createQuery("from com.springbootmvc.entity.FacebookUser f where f.email=:p");
			q.setParameter("p", value1);
		}
		if(option.equals("address")) {
			q=ss.createQuery("from com.springbootmvc.entity.FacebookUser f where f.address=:p");
			q.setParameter("p", value1);
		}
		
		List<FacebookUser> ff= q.getResultList();
		return ff;
	}

	@Override
	public int editProfileDAO(FacebookUser fb) {
		Session ss=sf.openSession();
		ss.merge(fb);
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		et.commit();
		return 1;
	}

	@Override
	public int deleteProfileDAO(FacebookUser fb) {
		Session ss=sf.openSession();
		Query q=ss.createQuery("delete from com.springbootmvc.entity.FacebookUser f where f.email=:p");
		q.setParameter("p", fb.getEmail());
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		
		int i=q.executeUpdate();
		
		et.commit();
		return i;
	}

}
