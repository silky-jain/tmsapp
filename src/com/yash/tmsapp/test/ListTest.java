package com.yash.tmsapp.test;

import java.util.List;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;

public class ListTest {

	public static void main(String[] args) {
		UserDAO userDAO= new UserDAOImpl();
		List<User> users=userDAO.list();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
