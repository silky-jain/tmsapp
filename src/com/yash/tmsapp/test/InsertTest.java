package com.yash.tmsapp.test;

import org.hibernate.Session;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.HibernateUtil;

public class InsertTest {

	public static void main(String[] args) {
		User user= new User();
		user.setName("hello");
		user.setEmail("silky@yash.com");
		user.setPhone("24565265265");
		user.setLoginname("silky");
		user.setPassword("silky123");
		Session session=HibernateUtil.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		
	}

}
