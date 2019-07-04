package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;

public class UpdateTest {

	public static void main(String[] args) {
		UserDAO userDAO= new UserDAOImpl();
		User user= new User();
		user.setId(9);
		user.setName("sheetal");
		user.setEmail("sheetal@yash.com");
		user.setPhone("24565265265");
		user.setLoginname("sheetal");
		user.setPassword("sheetal123");
		
		userDAO.update(user);

	}

}
