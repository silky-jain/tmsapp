package com.yash.tmsapp.test;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

public class AuthenticateTest {

	public static void main(String[] args) {
		UserService userService= new UserServiceImpl();
		try {
			User user=userService.authenticate("silky","silky123");
			System.out.println(user.getLoginname());
			System.out.println(user.getPassword());
			
		} catch (UserNotFoundException e) {
		
		System.out.println(e.getMessage());
		}

	}

}
