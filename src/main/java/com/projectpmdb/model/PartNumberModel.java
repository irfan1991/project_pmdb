package com.projectpmdb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PartNumberModel {
	

	private int id;
	private String part_number;
	private String part_name;
	private int part_stock;
	private int part_uom;
	private String  part_date;
	private int satuan_id;
	private String  part_date2;
	private String satuan;
	private String cari;
	private int jumlahPn;
	
	



	public PartNumberModel() {
		
	}


	public PartNumberModel(int id, String part_number, String part_name, int part_stock, int part_uom, String part_date,
			int satuan_id, String part_date2, String satuan, String cari, int jumlahPn) {
		
		this.id = id;
		this.part_number = part_number;
		this.part_name = part_name;
		this.part_stock = part_stock;
		this.part_uom = part_uom;
		this.part_date = part_date;
		this.satuan_id = satuan_id;
		this.part_date2 = part_date2;
		this.satuan = satuan;
		this.cari = cari;
		this.jumlahPn = jumlahPn;
	}


	public PartNumberModel(int id, String part_number, String part_name, int part_stock, int part_uom,
			String part_date) {
		
		this.id = id;
		this.part_number = part_number;
		this.part_name = part_name;
		this.part_stock = part_stock;
		this.part_uom = part_uom;
		this.part_date = part_date;
	}

	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getPart_number() {
		return part_number;
	}




	public void setPart_number(String part_number) {
		this.part_number = part_number;
	}




	public String getPart_name() {
		return part_name;
	}




	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}




	public int getPart_stock() {
		return part_stock;
	}




	public void setPart_stock(int part_stock) {
		this.part_stock = part_stock;
	}




	public int getPart_uom() {
		return part_uom;
	}




	public void setPart_uom(int part_uom) {
		this.part_uom = part_uom;
	}




	public String getPart_date() {
		return part_date;
	}




	public void setPart_date(String part_date) {
		this.part_date = part_date;
	}




	public int getSatuan_id() {
		return satuan_id;
	}




	public void setSatuan_id(int satuan_id) {
		this.satuan_id = satuan_id;
	}




	public String getPart_date2() {
		return part_date2;
	}




	public void setPart_date2(String part_date2) {
		this.part_date2 = part_date2;
	}




	public String getSatuan() {
		return satuan;
	}




	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}




	public String getCari() {
		return cari;
	}




	public void setCari(String cari) {
		this.cari = cari;
	}




	public int getJumlahPn() {
		return jumlahPn;
	}




	public void setJumlahPn(int jumlahPn) {
		this.jumlahPn = jumlahPn;
	}


	
	
	
	

}
