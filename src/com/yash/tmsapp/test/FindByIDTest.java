package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;

public class FindByIDTest {

	public static void main(String[] args) {
		UserDAO userDAO= new UserDAOImpl();
		System.out.print(userDAO.findById(1));
	}

}
