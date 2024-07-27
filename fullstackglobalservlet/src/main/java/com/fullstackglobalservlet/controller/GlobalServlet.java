package com.fullstackglobalservlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.fullstackglobalservlet.entity.MyEntity;
import com.fullstackglobalservlet.service.MyProjectService;
import com.fullstackglobalservlet.service.MyProjectServiceInterface;

public class GlobalServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");

		if (type.equals("registration")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			MyEntity m = new MyEntity();
			m.setFirstName(firstName);
			m.setLastName(lastName);
			m.setEmail(email);
			m.setPassword(password);
			m.setAddress(address);

			MyProjectServiceInterface mservice = new MyProjectService();
			int i = mservice.createProfileService(m);

			String result = "Registeration Fail";

			if (i > 0) {
				result = "Registration Success";

			}
			request.setAttribute("result", result);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(request, response);

		}
		if (type.equals("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			MyEntity m = new MyEntity();
			m.setEmail(email);
			m.setPassword(password);

			MyProjectServiceInterface mservice = new MyProjectService();
			boolean i = mservice.loginProfileService(m);

			if (i) {
				HttpSession ss = request.getSession(true);
				ss.setAttribute("uid", email);

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/userhomepage.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("result", "Invalid Id and Password");

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/signin.jsp");
				rd.forward(request, response);
			}

		}
		if (type.equals("viewProfile")) {
			HttpSession ss=request.getSession(true);
			String email=ss.getAttribute("uid").toString();
			
			MyEntity fuser=new MyEntity();
			fuser.setEmail(email);
			
			MyProjectServiceInterface mservice = new MyProjectService();
			MyEntity fb=mservice.viewProfileService(fuser);
			
			request.setAttribute("result", fb);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewProfile.jsp");
			rd.forward(request, response);
			
		}
		if (type.equals("editProfile")) {
			HttpSession ss=request.getSession(true);
			String email=ss.getAttribute("uid").toString();
			
			MyEntity fuser=new MyEntity();
			fuser.setEmail(email);
			
			MyProjectServiceInterface mservice = new MyProjectService();
			MyEntity fb=mservice.viewProfileService(fuser);
			
			request.setAttribute("result", fb);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/editProfile.jsp");
			rd.forward(request, response);
		}
		if (type.equals("searchProfile")) {

		}
		if (type.equals("deleteProfile")) {

		}
		if (type.equals("viewAll")) {

		}
		if (type.equals("logout")) {

		}
	}

}
