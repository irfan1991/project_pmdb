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


@Mapper
public interface PartNumberMapper {

	@Select("SELECT a.id as id , a.part_number as part_number, a.part_name as part_name , a.part_stock as part_stock, b.name as satuan , DATE_FORMAT(a.part_date, '%D %M %Y') as part_date  FROM t_pn a LEFT JOIN t_satuan b ON a.part_uom = b.id")
	@Results(value= {
            @Result(property = "part_number", column = "part_number"),
            @Result(property = "part_name", column = "part_name"),
            @Result(property = "satuan", column = "satuan"),
            @Result(property = "part_date", column = "part_date"),
            @Result(property = "part_stock", column = "part_stock"),
            })
	List<PartNumberModel> ambilSemua();
	
	
	
	@Select("SELECT a.id as id , a.part_number as part_number, a.part_name as part_name , a.part_stock as part_stock, b.name as satuan , DATE_FORMAT(a.part_date, '%D %M %Y') as part_date  FROM t_pn a LEFT JOIN t_satuan b ON a.part_uom = b.id  WHERE a.part_date BETWEEN #{part_date} AND #{part_date2}")
	@Results(value= {
            @Result(property = "part_number", column = "part_number"),
            @Result(property = "part_name", column = "part_name"),
            @Result(property = "satuan", column = "satuan"),
            @Result(property = "part_date", column = "part_date"),
            @Result(property = "part_stock", column = "part_stock"),
            })
	List<PartNumberModel> ambilDate( @Param("part_date")  String date1,@Param("part_date2") String date2);
	
	
	@Insert("INSERT INTO t_pn (part_number, part_name, part_stock,part_uom,part_date) VALUES (#{part_number},#{part_name},#{part_stock},#{part_uom},#{part_date})")
	void simpanData(PartNumberModel partNumberModel);
	
	@Update("UPDATE t_pn SET part_number=#{part_number}, part_name=#{part_name}, part_stock=#{part_stock}, part_uom=#{part_uom} ,part_date=#{part_date} WHERE id=#{id}")
	void updateData(PartNumberModel partNumberModel);
	
	@Select("SELECT * FROM v_pn2 WHERE id=#{id}")
	@Results(value  = {
			@Result(property = "id",column ="id"),
			@Result(property="part_number",column="part_number"),
			@Result(property="part_name",column="part_name"),
			@Result(property="satuan", column="part_uom"),
			@Result(property="part_date",column="part_date"),
			@Result(property="part_stock",column="part_stock"),
			@Result(property="satuan_id",column="satuan_id"),
			@Result(property="part_date",column="part_date")
			})
	PartNumberModel selectId(int idPartNumber);
	
	
	@Select("SELECT * FROM v_pn WHERE id=#{id}")
	@Results(value  = {
			@Result(property = "id",column ="id"),
			@Result(property="part_number",column="part_number"),
			@Result(property="part_name",column="part_name"),
			@Result(property="satuan", column="part_uom"),
			@Result(property="part_date",column="part_date"),
			@Result(property="part_stock",column="part_stock"),
			@Result(property="satuan_id",column="satuan_id"),
			@Result(property="part_date",column="part_date")
			})
	PartNumberModel selectView(int idPartNumber);
	
	@Select("SELECT id,part_number,part_name,part_stock,part_uom,DATE_FORMAT( part_date , '%D %M %Y')  AS part_date FROM t_pn WHERE  part_date BETWEEN #{part_date} AND #{part_date2}")
	List<PartNumberModel> ambilSemuaByDate( @Param("part_date")  String date1,@Param("part_date2") String date2);
	
	@Select("select * from t_pn WHERE part_name LIKE #{cari}")
	List<PartNumberModel> ambilNamaBarang( @Param("cari") String cari);

	
	@Delete("DELETE FROM t_pn WHERE id=#{id}")
	void deleteData(int idPartNumber);
	
	@Select(" SELECT COUNT(*) AS jumlah_pn FROM t_pn;")
	@Results(value  = {
			@Result(property = "jumlahPn",column ="jumlah_pn"),
			
			})
	List<PartNumberModel> getJumlahPnMapper();
	
}
