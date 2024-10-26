package com.springbootmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbootmvc.entity.FacebookUser;
import com.springbootmvc.service.FacebookService;
import com.springbootmvc.service.FacebookServiceInterface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyProjectController {
	
	@Autowired
	private FacebookServiceInterface fs;  //FacebookServiceInterface fs=new FacebookService();
	
	
	@RequestMapping("register")
	public ModelAndView registerUser(@RequestParam("nm") String name,@RequestParam("pwd") String password,@RequestParam("em") String email,@RequestParam("address") String address) {
		//String name=request.getPrameter("nm"); == @RequestParam("nm") String name
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		int i=fs.createProfile(fb);
		
		ModelAndView mv=new ModelAndView();
		
		if(i>0) {
			mv.addObject("result", "Registration Success <a href=login.jsp>Sign In </a>");
		}
		mv.setViewName("register.jsp");
		
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView loginUser(@RequestParam("pwd") String password,@RequestParam("em") String email,HttpServletRequest request) {
		//String name=request.getPrameter("nm"); == @RequestParam("nm") String name
		
		FacebookUser fb=new FacebookUser();
		
		fb.setPassword(password);
		fb.setEmail(email);
		
		
		int i=fs.loginProfile(fb);
		
		ModelAndView mv=new ModelAndView();
		
		if(i>0) {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("userid", email);
			
			List<FacebookUser> i1=new ArrayList<FacebookUser>();
			
			mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
			mv.addObject("result1", i1);
			mv.setViewName("dashboard.jsp");
			
		}
		else {
			mv.addObject("result", "Invalid Id and Password");
			mv.setViewName("login.jsp");
			
		}
		
		
		return mv;
	}
	
	@RequestMapping("lviewprofile")
	public ModelAndView viewprofileUser(HttpServletRequest request) {
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
				
		List<FacebookUser> i=fs.viewProfile(fb);
		
		ModelAndView mv=new ModelAndView();
		
		if(i.size()>0) {
			mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
			
			mv.addObject("result1", i);
			mv.setViewName("dashboard.jsp");
		}
		
    	return mv;
	}
	@RequestMapping("viewallprofile")
	public ModelAndView viewallprofileUser(HttpServletRequest request) {
		
		
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		
		List<FacebookUser> i=fs.viewallProfile();
		
		ModelAndView mv=new ModelAndView();
		
		if(i.size()>0) {
			mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
			
			mv.addObject("result1", i);
			mv.setViewName("dashboard.jsp");
		}
		else {
			
		}
		
    	return mv;
	}
	@RequestMapping("searchprofile")
	public ModelAndView searchprofileUser(HttpServletRequest request) {
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		
		List<FacebookUser> i1=new ArrayList<FacebookUser>();
				
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
		mv.addObject("result1", i1);
		mv.setViewName("search.jsp");
	
    	return mv;
	}
	
	@RequestMapping("searchprofile1")
	public ModelAndView searchprofileUser1(HttpServletRequest request,@RequestParam("soption") String option) {
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		String value1=null;
		if(option.equals("name")) {
			value1=request.getParameter("name");
		}
		if(option.equals("email")) {
			value1=request.getParameter("email");
		}
		if(option.equals("address")) {
			value1=request.getParameter("address");
		}
		
		List<FacebookUser> i=fs.searchProfile(option,value1);
				
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
		mv.addObject("result1", i);
		mv.setViewName("search.jsp");
	
    	return mv;
	}
	@RequestMapping("editprofile")
	public ModelAndView editprofileUser(HttpServletRequest request) {
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
				
		List<FacebookUser> i=fs.viewProfile(fb);
		
		ModelAndView mv=new ModelAndView();
		
		if(i.size()>0) {
			mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
			
			mv.addObject("result1", i);
			mv.setViewName("editpage.jsp");
		}
		
    	return mv;
	}
	
	@RequestMapping("editprofile1")
	public ModelAndView editprofile1(HttpServletRequest request,@RequestParam("nm") String name,@RequestParam("pwd") String password,@RequestParam("ad") String address) {
		//String name=request.getPrameter("nm"); == @RequestParam("nm") String name
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		int i=fs.editProfile(fb);
		List<FacebookUser> i1=new ArrayList<FacebookUser>();
		
		ModelAndView mv=new ModelAndView();
		
		if(i>0) {
			mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
			mv.addObject("result1", i1);
			mv.addObject("result2", "profile edited");
		}
		mv.setViewName("editpage.jsp");
		
		return mv;
	}
	
	@RequestMapping("deleteprofile")
	public ModelAndView deleteprofile(HttpServletRequest request) {
		//String name=request.getPrameter("nm"); == @RequestParam("nm") String name
		HttpSession hs=request.getSession(true);
		String email=hs.getAttribute("userid").toString();
		
		FacebookUser fb=new FacebookUser();
		
		fb.setEmail(email);
		
		
		int i=fs.deleteProfile(fb);
		List<FacebookUser> i1=new ArrayList<FacebookUser>();
		
		ModelAndView mv=new ModelAndView();
		
		if(i>0) {
			mv.addObject("result", "Welcome "+email+" <a href=lviewprofile>ViewProfile</a><a href=searchprofile>Search Profile</a><a href=deleteprofile>Delete Profile</a><a href=editprofile>Edit Profile</a><a href=viewallprofile>View All Profile</a>");
			mv.addObject("result1", i1);
			mv.addObject("result2", "profile deleted");
		}
		mv.setViewName("deletepageresult.jsp");
		
		return mv;
	}
}
