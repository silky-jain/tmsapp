package com.yash.tmsapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;

import com.yash.tmsapp.util.HibernateUtil;

public class TrainingDAOImpl extends HibernateUtil implements TrainingDAO {

	@Override
	public void insert(Training training) {

		Transaction tx = null;
		Session session = HibernateUtil.openSession();
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(training);
			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(int id) {

		Transaction tx = null;
		Session session = HibernateUtil.openSession();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("delete from Training where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Training training) {
		delete(training.getId());

	}

	@Override
	public Training findById(int id) throws TrainingNotFoundException {

		Training training = new Training();

		Transaction tx = null;
		Session session = HibernateUtil.openSession();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Training where id=:id");
			query.setParameter("id", id);
			List<Training> trainings = query.list();
			training = trainings.get(0);
			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return training;
	}

	@Override
	public List<Training> find(String searchtext) {

		searchtext = "%" + searchtext + "%";
		List<Training> trainings = new ArrayList<Training>();

		Transaction tx = null;
		Session session = HibernateUtil.openSession();
		Criteria cr = session.createCriteria(Training.class);
		try {
			tx = session.beginTransaction();
			Criterion title = Restrictions.like("title", searchtext);
			Criterion objective = Restrictions.like("objective", searchtext);

			Criterion course = Restrictions.like("course", searchtext);
			Criterion expectation = Restrictions.like("expectation", searchtext);

			Criterion completequery = Restrictions.disjunction().add(title).add(objective).add(course).add(expectation);
			cr.add(completequery);
			trainings = cr.list();

			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return trainings;
	}

	@Override
	public List<Training> list() {

		List<Training> trainings = new ArrayList<Training>();

		Transaction tx = null;
		Session session = HibernateUtil.openSession();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Training");
			trainings = query.list();

			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return trainings;
	}

	@Override
	public void update(Training training) {

		Session session = openSession();
		session.beginTransaction();
		session.update(training);

		session.getTransaction().commit();
		session.close();

	}

}
