package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.domain.Training;

public class TrainingDAOImpl_DeleteTest {

	public static void main(String[] args) {
		TrainingDAO trainingDAO= new TrainingDAOImpl();
		String test="test";
		Training training= new Training();
		trainingDAO.delete(1);
		System.out.println("succesful");
	}

}
