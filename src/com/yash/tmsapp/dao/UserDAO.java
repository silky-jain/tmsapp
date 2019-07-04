package com.yash.tmsapp.dao;

import java.util.List;

import com.yash.tmsapp.domain.User;
/**
 * this will perfrom all CRUD operations on User
 * @author silky.jain
 *
 */

public interface UserDAO {
/**
 * This will insert the user in database
 * @param user to be inserted
 */
	void insert(User user);
	/**
	 * this will delete the user with given id
	 * @param id of user to be deleted
	 */

	void delete(int id);
/**
 * This will give the list  of users
 * @return the list of users
 */
	List<User> list();
	/**
	 * this will update the user
	 * @param user to be updated
	 */
	void update(User user);
	/**
	 * this will find the user by given id
	 * @param id of user to be searched
	 * @return the user with provided id
	 */
	User findById(int id);
	/**
	 * this will  find the users with given text
	 * @param searchtext which  to be  found in users list
	 * @return the list of users with given text
	 */
	List<User> find(String searchtext);
	/**
	 * this will delete the user 
	 * @param user to be deleted
	 */
	void delete(User user);
	
}
