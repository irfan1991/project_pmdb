package com.projectpmdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class UserModel {
	private int id;
	private String password;
	private String passwordConfirm;
    private String loginId;
	private String userName;
	private int active;
	

	private String createdAt;
	private String createdAt2;
	private String status;
	private String file;
	
	public UserModel() {
		
	}
	
	
	public UserModel(int id, String password, String createdAt) {
		this.id = id;
		this.password = password;
		this.createdAt = createdAt;
	}
	
	
	public UserModel(int id, String password, String passwordConfirm, String loginId, String userName, int active,
			String createdAt) {
		this.id = id;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.loginId = loginId;
		this.userName = userName;
		this.active = active;
		this.createdAt = createdAt;
	}

	public UserModel(int id, String loginId, String userName, String createdAt) {
		this.id = id;
		this.loginId = loginId;
		this.userName = userName;
		this.createdAt = createdAt;
	}

	public UserModel(int id, String loginId, String userName, int active, String createdAt) {
		this.id = id;
		this.loginId = loginId;
		this.userName = userName;
		this.active = active;
		this.createdAt = createdAt;
	}


	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	

}
