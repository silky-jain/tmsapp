package com.yash.tmsapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * DBUtil is used for getting prepareStatement object and for shutting down the objects
 * @author silky.jain
 *
 */

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static {
//		try{
////			sessionFactory =  new AnnotationConfiguration().
////					configure("hibernate.cfg.xml").buildSessionFactory();
////		}
////		catch(Throwable ex){
////			System.err.println("Initial SessionFactory Creation Failure : "+ex);
////			throw new ExceptionInInitializerError(ex);
////		}
		
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
}
