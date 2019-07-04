package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService userService=new UserServiceImpl();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user =new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setLoginname(request.getParameter("loginname"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
	
		userService.register(user);
		response.sendRedirect("UserLogin.jsp?msg=You have registered successfully");
	}

}
