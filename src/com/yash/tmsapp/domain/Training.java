package com.yash.tmsapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This TrainingDAO class will work as Data Transfer Object
 * 
 * @author silky.jain
 *
 */
@Entity
@Table(name="trainings")
public class Training {
	/**
	 * id of training
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**
	 * id of user
	 */
	@OneToOne
	private User user = new User(); 
	/**
	 * title of training
	 */
	private String title;
	/**
	 * objective of training
	 */
	private String objective;
	/**
	 * course of training
	 */
	private String course;
	/**
	 * mode of training
	 */
	private int mode;
	/**
	 * batchsize of training
	 */
	private int batchsize;
	/**
	 * expectation of training
	 */
	private String expectation;
	/**
	 * duration of training
	 */

	private int duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getBatchsize() {
		return batchsize;
	}

	public void setBatchsize(int batchsize) {
		this.batchsize = batchsize;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
