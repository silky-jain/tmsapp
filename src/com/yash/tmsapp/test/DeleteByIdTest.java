package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;

public class DeleteByIdTest {

	public static void main(String[] args) {
		UserDAO userDAO= new UserDAOImpl();
		userDAO.delete(3);

	}

}
