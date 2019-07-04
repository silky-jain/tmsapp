package com.yash.tmsapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.HibernateUtil;

public class UserDAOImpl extends HibernateUtil implements UserDAO {

	@Override
	public void insert(User user) {

		Session session = openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void delete(int id) {
	
		Session session = openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from User where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<User> list() {
		List<User> users = new ArrayList<>();

		Session session = openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		users=query.list();
		session.getTransaction().commit();
		session.close();
		

		return users;
	}


	@Override
	public void update(User user) {

		
		Session session = openSession();
		session.beginTransaction();
		 session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
		

	}

	@Override
	public User findById(int id) {
		User searcheduser = new User();

		
		Session session = openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where id=:id");
		query.setParameter("id", id);
		List< User> users= query.list();
		searcheduser=users.get(0);
		session.getTransaction().commit();
		session.close();
		
		
		return searcheduser;
	}

	@Override
	public List<User> find(String searchtext) {
		List<User> searchedusers = list();

		
		Session session = openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		Criterion name=Restrictions.like("name",searchtext);
		Criterion phone=Restrictions.like("phone",searchtext);
		
		Criterion email=Restrictions.like("email",searchtext);
		Criterion loginname=Restrictions.like("loginname",searchtext);
		
		Criterion completequery=Restrictions.disjunction().add(loginname).add(email).add(phone).add(name);
		cr.add(completequery);
		searchedusers= cr.list();
	
		session.getTransaction().commit();
		session.close();
		return searchedusers;
	}

	@Override
	public void delete(User user) {
		delete(user.getId());

	}

}
