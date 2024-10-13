package com.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbootmvc.entity.FacebookUser;
import com.springbootmvc.service.FacebookService;
import com.springbootmvc.service.FacebookServiceInterface;

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
			mv.addObject("result", "Registration Success");
		}
		mv.setViewName("register.jsp");
		
		return mv;
	}
}
