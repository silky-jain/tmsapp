package com.yash.tmsapp.test;

import java.sql.Connection;

import org.hibernate.Session;

import com.yash.tmsapp.util.HibernateUtil;

public class DBUtilTest extends HibernateUtil{

	public static void main(String[] args) {

		Session session = openSession();
		session.beginTransaction();
		System.out.println(session);
		session.getTransaction().commit();
		session.close();


	}

}
