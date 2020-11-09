package com.projectpmdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.SupplierModel;

@Mapper
public interface SupplierMapper {
	
	@Select("SELECT * FROM t_suplier")
	List<SupplierModel> selectAllSuplier();
	
	@Insert("INSERT INTO t_suplier(nama,alamat,no_tel) VALUES (#{nama},#{alamat},#{no_tel});")
	void addSupplierMapper(SupplierModel supplierModel);
	
	@Delete("DELETE FROM t_suplier WHERE id=#{id} ")
	void deleteSupplierMapper(int id);
	
	@Select("SELECT *FROM t_suplier WHERE id=#{id} ")
	SupplierModel getViewMapper(int id);
	
	@Select("SELECT * FROM t_suplier WHERE id=#{id}")
	SupplierModel getEditMapper(int id);
	
	@Update("UPDATE t_suplier SET nama=#{nama}, alamat=#{alamat}, no_tel=#{no_tel} WHERE id=#{id}")
	void updateSupplierMapper(SupplierModel supplier);

	@Select("SELECT * FROM t_suplier WHERE nama LIKE #{cari};")
	List<SupplierModel> cariSupplier(@Param("cari")String cari);
	

	@Select(" SELECT COUNT(*) AS jumlah_suplier FROM t_suplier;")
	@Results(value  = {
			@Result(property = "jumlahSupplier",column ="jumlah_suplier"),
			
			})
	List<SupplierModel> getJumlahSupplierMapper();
}
