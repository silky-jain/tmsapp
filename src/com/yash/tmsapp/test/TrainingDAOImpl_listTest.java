package com.yash.tmsapp.test;

import java.util.ArrayList;
import java.util.List;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;

public class TrainingDAOImpl_listTest {

	public static void main(String[] args) {
		TrainingDAO trainingDAO= new TrainingDAOImpl();
		String test="test";
//		Training training= new Training();
//		try {
//			training=trainingDAO.findById(1);
//			System.out.println(training.getTitle()+training.getObjective());
//			
//		} catch (TrainingNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
		
		List<Training> trainings= new ArrayList<>();
		
		
			trainings=trainingDAO.list();
			System.out.println(trainings);
			for (Training training : trainings) {
				System.out.println(training.getTitle()+training.getObjective());
			}
			
		
	}

}
