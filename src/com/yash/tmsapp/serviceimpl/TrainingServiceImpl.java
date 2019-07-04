package com.yash.tmsapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.util.HibernateUtil;

public class TrainingServiceImpl extends HibernateUtil implements TrainingService {

	TrainingDAO trainingDAO = null;
	HttpSession session = null;

	public TrainingServiceImpl() {
		trainingDAO = new TrainingDAOImpl();

	}

	@Override
	public List<Training> listTraining() {

		return trainingDAO.list();
	}

	@Override
	public List<Training> find(String textsearch) {
		
		return trainingDAO.find(textsearch);
	}

	@Override
	public void edit(Training training) {
	trainingDAO.update(training);

	}

	@Override
	public void requestTraining(Training training) {
		trainingDAO.insert(training);

	}

	@Override
	public void delete(Training training) {
		trainingDAO.delete(training);
	}

	@Override
	public List<Training> listTraining(int userid, int role) {

		if (role == 2) {
			List<Training> trainings = new ArrayList<Training>();

		
			Transaction tx = null;
			Session session = HibernateUtil.openSession();
			try {
				tx = session.beginTransaction();
				Query query = session.createQuery("from Training T where user.id=:userid");
				query.setParameter("userid",userid);
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
			System.out.println(trainings);
			return trainings;
		} else {
			return listTraining();
		}
	}

	

	
	@Override
	public Training findById(int id) {
		Training training=null;
		try {
			 training= trainingDAO.findById(id);
		} catch (TrainingNotFoundException e) {
			
			e.printStackTrace();
		}
		return training;
	}
}
