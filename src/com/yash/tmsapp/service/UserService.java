package com.yash.tmsapp.service;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
/**
 * this UserService will perform all operations on Modal object
 * @author silky.jain
 *
 */
public interface UserService {
/**
 * To set the role of business 
 */
int ROLE_BUSINESS=2;
/**
 * to set the role of L&D
 */
int ROLE_LD=1;
/**
 * to set the status as active
 */
int STATUS_ACTIVE=1;
/**
 * to set the status as blocked
 */
int STATUS_BLOCKED=2;
	
/**
 * this will add the user in the database	
 * @param user to be added
 */
void register(User user);
/**
 * This will check availability of user on basis of loginname and password provided
 * @param loginname of user to be checked
 * @param password of user to be checked
 * @return User
 * @throws UserNotFoundException 
 */
User authenticate(String loginname,String password) throws UserNotFoundException;
}
