package com.nagarro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class User {

	@Id
	@Column(name = "Username")
	private String username;

	@Column(name = "Full_Name")
	private String fullName;

	public User() {

	}

	public User(String username, String fullName, String password) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Column(name = "Password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
