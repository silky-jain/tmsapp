package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;

public class DeleteTest {

	public static void main(String[] args) {
		UserDAO userDAO=new UserDAOImpl();
		User user=new User();
		user.setEmail("palash@yash.com");
		userDAO.delete(user);

	}

}
