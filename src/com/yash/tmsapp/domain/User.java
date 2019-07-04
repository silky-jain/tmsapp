package com.yash.tmsapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * this will work as data transfer object
 * 
 * @author silky.jain
 *
 */
@Entity
@Table(name="users")
public class User {
	/**
	 * id of user
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**
	 * name of user
	 */
	private String name;

	/**
	 * phone of user
	 */
	private String phone;
	/**
	 * email of user
	 */
	private String email;
	/**
	 * loginname of user
	 */
	private String loginname;

	/**
	 * password of user
	 */
	private String password;
	/**
	 * role of user 1.L&D 2.Business
	 */
	private int role;
	/**
	 * status of user 1. active 2.blocked
	 */
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", loginname="
				+ loginname + ", password=" + password + ", role=" + role + ", status=" + status + "]";
	}
	

}
