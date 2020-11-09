package com.projectpmdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.projectpmdb.model.SatuanModel;

@Mapper
public interface SatuanMapper {
	
	@Select("SELECT * FROM t_satuan")
	List<SatuanModel> ambilSemuaSatuan();
	
	@Insert("INSERT INTO t_satuan (name) VALUES (#{name})")
	void addSatuan(SatuanModel satuanModel);
	
	@Select("SELECT * FROM t_satuan WHERE id=#{id}")
	SatuanModel getView(int id);
	
	@Select("SELECT * FROM t_satuan WHERE id=#{id}")
	SatuanModel getEdit(int id);
	
	@Delete("DELETE FROM t_satuan WHERE id=#{id}")
	void deleteSatuan(int satuan);

	@Update("UPDATE t_satuan SET name=#{name} WHERE id=#{id}")
	void updateSatuan(SatuanModel satuans);
	
	@Select("SELECT * FROM t_satuan WHERE name LIKE #{cari}")
	List<SatuanModel> cariSatuan(@Param("cari") String cari);
}
