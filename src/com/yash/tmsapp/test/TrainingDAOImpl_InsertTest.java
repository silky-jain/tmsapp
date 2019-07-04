package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;

public class TrainingDAOImpl_InsertTest {

	public static void main(String[] args) {
		TrainingDAO trainingDAO= new TrainingDAOImpl();
		String test="test";
		Training training= new Training();
		User user= new User();
		training.setUser(user);
		training.setTitle(test);
		training.setBatchsize(10);
		training.setCourse(test);
		training.setDuration(1);
		training.setExpectation(test);
		training.setMode(1);
		training.setObjective(test);
		
		
		trainingDAO.insert(training);
	}

}
