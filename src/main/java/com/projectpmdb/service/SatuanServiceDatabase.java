package com.projectpmdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpmdb.dao.SatuanMapper;
import com.projectpmdb.model.SatuanModel;


@Service
public class SatuanServiceDatabase  implements SatuanService {

	@Autowired
	SatuanMapper satuanMapper;
	
	@Override
	public List<SatuanModel> selectAllSatuan() {
		// TODO Auto-generated method stub
		return satuanMapper.ambilSemuaSatuan();
	}

	@Override
	public void addSatuan(SatuanModel satuanModel) {
		// TODO Auto-generated method stub
		satuanMapper.addSatuan(satuanModel);
		
	}

	@Override
	public void deleteSatuan(int satuan) {
		// TODO Auto-generated method stub
		satuanMapper.deleteSatuan(satuan);
	}

	@Override
	public SatuanModel getView(int id) {
		// TODO Auto-generated method stub
		return satuanMapper.getView(id);
	}

	@Override
	public SatuanModel getEdit(int id) {
		// TODO Auto-generated method stub
		return satuanMapper.getEdit(id);
	}

	@Override
	public void updatedSatuan(SatuanModel satuanModel) {
		// TODO Auto-generated method stub
		satuanMapper.updateSatuan(satuanModel);
	}

	@Override
	public List<SatuanModel> cariSatuan(String cari) {
		// TODO Auto-generated method stub
		return satuanMapper.cariSatuan('%'+cari+'%');
	}

}
