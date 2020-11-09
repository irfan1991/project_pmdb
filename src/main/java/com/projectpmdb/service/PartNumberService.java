package com.projectpmdb.service;

import java.util.List;

import com.projectpmdb.model.PartNumberModel;


public interface PartNumberService {

	List<PartNumberModel> selectAll();
	void addPartNumber(PartNumberModel partNumberModel);
	void updatePartNumber(PartNumberModel partNumberModel);
	void deletePartNumber(int idPartNumber);
	PartNumberModel selectView(int idPartNumber);
	PartNumberModel getView(int id);
	List<PartNumberModel> getCariBarang(String part_name);
	List<PartNumberModel> selectByDate(String date1, String date2);
	List<PartNumberModel> selectDate(String date1, String date2);
	List<PartNumberModel> getCountPN();
	
	
}
