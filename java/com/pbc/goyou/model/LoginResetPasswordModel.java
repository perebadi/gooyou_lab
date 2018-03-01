package com.pbc.goyou.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.pbc.goyou.validation.ExistUsernameConstraint;

public class LoginResetPasswordModel {

	@ExistUsernameConstraint
	@NotEmpty
	private String username;
	private String password;
	
	public LoginResetPasswordModel() {
	}

	public LoginResetPasswordModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
