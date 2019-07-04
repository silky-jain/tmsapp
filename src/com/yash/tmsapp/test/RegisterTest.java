package com.yash.tmsapp.test;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

public class RegisterTest {

	public static void main(String[] args) {
		UserService userService= new UserServiceImpl();
		User user= new User();
		user.setName("shivangi");
		user.setEmail("shivangi@yash.com");
		user.setPhone("24565265265");
		user.setLoginname("shivangi");
		user.setPassword("shivangi");
		
		userService.register(user);
		System.out.println("success");
	}

}
