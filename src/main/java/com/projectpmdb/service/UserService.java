package com.projectpmdb.service;

import java.util.List;

import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.UserModel;

public interface UserService {

	List<UserModel> selectAllUsers();
	void deleteUser(int id);
	UserModel getEdit(int id);
	UserModel getView(int id);
	void updateUser(UserModel userModel);
	void updatePassword(UserModel userModel);
	List<UserModel> cariNamaUser(String user);
	List<UserModel> searchDate(String date1, String date2);
	
}
