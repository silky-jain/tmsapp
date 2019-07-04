package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService= new UserServiceImpl();
		try {
		User loggedInUser =userService.authenticate(request.getParameter("loginname"),request.getParameter("password") );
		HttpSession session=request.getSession();
		session.setAttribute("loggedInUser", loggedInUser);
		session.setAttribute("loggedInUserId",loggedInUser.getId());
		session.setAttribute("loggedInUserRole",loggedInUser.getRole());
		response.sendRedirect("User-Dashboard.jsp");
		} catch (UserNotFoundException e) {
			String errmsg=e.getMessage();
			response.sendRedirect("UserLogin.jsp?msg="+errmsg+"");
		}
	}

}
