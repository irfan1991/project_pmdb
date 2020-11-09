package com.projectpmdb.service;


import java.util.List;

import com.projectpmdb.model.SatuanModel;

public interface SatuanService {

	
	List<SatuanModel>  selectAllSatuan();
	void addSatuan (SatuanModel satuanModel);
	void deleteSatuan(int satuan);
	SatuanModel getView(int id);
	SatuanModel getEdit(int id);
	void updatedSatuan(SatuanModel satuanModel);
	List<SatuanModel> cariSatuan(String cari);
	
}
