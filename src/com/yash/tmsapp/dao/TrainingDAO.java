package com.yash.tmsapp.dao;

import java.util.List;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;

/**
 * This TrainingDAO class will perform CRUD operations on Training Object
 * 
 * @author silky.jain
 *
 */
public interface TrainingDAO {

	/**
	 * This will insert the training in database
	 * 
	 * @param training
	 *            to be inserted
	 */
	void insert(Training training);

	/**
	 * This will delete training by given Id
	 * 
	 * @param id
	 *            of training to be deleted
	 */
	void delete(int id);

	/**
	 * this will delete the training
	 * 
	 * @param training
	 *            to be deleted
	 */
	void delete(Training training);

	/**
	 * this will find training with specified id
	 * 
	 * @param id
	 *            of training to be found
	 * @return the Training with specified id
	 * @throws TrainingNotFoundException 
	 */
	Training findById(int id) throws TrainingNotFoundException;

	/**
	 * this will find the training with specified text
	 * 
	 * @param searchtext
	 *            to find the training
	 * @return 
	 */
	List<Training> find(String searchtext);

	/**
	 * This will return the list of trainings
	 * 
	 * @return the list of trainings
	 */
	List<Training> list();

	/**
	 * this will update the training
	 * 
	 * @param training
	 *            to be updated
	 */
	void update(Training training);

}
