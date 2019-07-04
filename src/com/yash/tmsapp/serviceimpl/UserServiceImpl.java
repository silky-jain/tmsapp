package com.yash.tmsapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.util.HibernateUtil;

public class UserServiceImpl extends HibernateUtil implements UserService {
	
	UserDAO userDAO=null;
	public UserServiceImpl() {
		 userDAO= new UserDAOImpl();
	}

	@Override
	public void register(User user) {
		user.setRole(ROLE_BUSINESS);
		user.setStatus(STATUS_ACTIVE);
		userDAO.insert(user);

	}

	@Override
	public User authenticate(String loginname, String password) throws UserNotFoundException {
//		String sql="SELECT * FROM users WHERE loginname = ? AND PASSWORD =?";
//		PreparedStatement psmt= preparedStatement(sql);
		User user= new User();
//		try {
//			psmt.setString(1,loginname);
//			psmt.setString(2,password);
//			ResultSet rs=psmt.executeQuery();
//			if(rs.next()) {
//				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
//				user.setEmail(rs.getString("email"));
//				user.setLoginname(rs.getString("loginname"));
//				user.setPassword(rs.getString("password"));
//				user.setPhone(rs.getString("phone"));
//				user.setRole(rs.getInt("role"));
//				user.setStatus(rs.getInt("status"));
//			}
//			else {
//				throw new UserNotFoundException("Incorrect loginname or password");
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		Transaction tx = null;
		Session session=HibernateUtil.openSession();
		try {
			tx=	session.beginTransaction();
			Query query= session.createQuery("from User where loginname=:loginname and password=:password");
			query.setString("loginname", loginname);
			query.setString("password",password);
			List< User>users=query.list();
			user=users.get(0);
			tx.commit();
	
		} catch (Throwable ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return user;

	}

}
