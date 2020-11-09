package com.projectpmdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SupplierModel {
	
	private int id;
	private String nama;
	private String alamat;
	private String no_tel;
	private String cari ;
	private int jumlahSupplier;
	
	
	
	public SupplierModel() {
		
	}



	public SupplierModel(int id, String nama, String alamat, String no_tel) {
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.no_tel = no_tel;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNama() {
		return nama;
	}



	public void setNama(String nama) {
		this.nama = nama;
	}



	public String getAlamat() {
		return alamat;
	}



	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}



	public String getNo_tel() {
		return no_tel;
	}



	public void setNo_tel(String no_tel) {
		this.no_tel = no_tel;
	}



	public String getCari() {
		return cari;
	}



	public void setCari(String cari) {
		this.cari = cari;
	}



	public int getJumlahSupplier() {
		return jumlahSupplier;
	}



	public void setJumlahSupplier(int jumlahSupplier) {
		this.jumlahSupplier = jumlahSupplier;
	}
	
	
	

}
