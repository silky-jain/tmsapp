package com.yash.tmsapp.service;

import java.util.List;

import com.yash.tmsapp.domain.Training;
/**
 * This interface performs all operations on modal object
 * @author silky.jain
 *
 */
public interface TrainingService {
	/**
	 * set the mode as classroom
	 */
	int MODE_CLASSROOM = 1;
	/**
	 * set the mode as online
	 */
	int MODE_ONLINE=2;
	/**
	 * this will return the list of trainings
	 * @return the list of training
	 */
	List<Training> listTraining();
	/**
	 * this will return the list of training 
	 * @param userid of the user
	 * @param role of the user
	 * @return the list of training
	 */
	List< Training> listTraining(int userid,int role);
	/**
	 * this will return the list of training on the basis of specified textsearch
	 * @param textsearch to be  used for searching training
	 * @return  list of training
	 */
	List<Training> find(String textsearch);
	/**
	 * this will return the training by given id
	 * @param id of training
	 * @return the training
	 */
	
	Training findById(int id);
	/**
	 * This will update the training
	 * @param training to be updated
	 */
	void edit(Training training);
	/**
	 * this will insert the training in the database
	 * @param training to be inserted
	 */
	void requestTraining(Training training) ;
	/**
	 * this will delete the training
	 * @param training to be deleted
	 */
	void delete(Training training);
	
	
	
	
	
	

}
