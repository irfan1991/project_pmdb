package com.projectpmdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SatuanModel {
	
	private int id;
	private String name;
	private String cari;
	
	
	
	public SatuanModel() {
		
	}



	public SatuanModel(int id, String name, String cari) {
		this.id = id;
		this.name = name;
		this.cari = cari;
	}



	public SatuanModel(int id ,String name) {
		this.id =id;
		this.name =name;
	}



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



	public String getCari() {
		return cari;
	}



	public void setCari(String cari) {
		this.cari = cari;
	}
	
	
	

}
