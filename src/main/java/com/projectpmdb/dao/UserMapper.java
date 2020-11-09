package com.projectpmdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.projectpmdb.model.PartNumberModel;
import com.projectpmdb.model.SatuanModel;
import com.projectpmdb.model.UserModel;

@Component
@Mapper
public interface UserMapper {
	UserModel findUserByLoginId(@Param("loginId") String loginId);
    int setUserInfo(@Param("param") UserModel param);
    
    @Select("SELECT user_id,user_name,login_id, CASE WHEN active = 1 THEN \"Active\" ELSE \"Non Active\" END AS status,active, DATE_FORMAT(created_at, '%D %M %Y') as created_at FROM user ;")
    @Results(value= {
    		@Result(property = "id", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "loginId", column = "login_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "active", column = "active"),
            @Result(property = "createdAt", column = "created_at"),
            })
    List<UserModel> selectSemuaUser();
    
    @Delete("DELETE FROM user WHERE user_id=#{id} ")
	void deleteUserMapper(int id);
    
    @Select("SELECT user_id,user_name,login_id,active,created_at FROM user WHERE user_id=#{id} ")
    @Results(value= {
    		@Result(property = "id", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "loginId", column = "login_id"),
            @Result(property = "active", column = "active"),
            @Result(property = "createdAt", column = "created_at"),
            })
    UserModel getEditMapper(int id);
    
    @Update("UPDATE user SET user_name=#{userName},login_id=#{loginId},created_at=#{createdAt},active=#{active} WHERE user_id=#{id}")
	void updateUserMapper(UserModel userModel);
    
    
    @Update("UPDATE user SET password =#{password} WHERE  user_id=#{id};")
    void updatePasswordMapper(UserModel userModel);
    
    @Select("SELECT user_id,user_name,login_id,CASE WHEN active = 1 THEN \"Active\" ELSE \"Non Active\" END AS status, DATE_FORMAT(created_at, '%D %M %Y') as created_at FROM user WHERE user_id=#{id} ")
    @Results(value= {
    		@Result(property = "id", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "loginId", column = "login_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdAt", column = "created_at"),
            })
    UserModel getViewMapper(int id);
    
    
    @Select("SELECT user_id,user_name,login_id, CASE WHEN active = 1 THEN \"Active\" ELSE \"Non Active\" END AS status,active, DATE_FORMAT(created_at, '%D %M %Y') as created_at FROM user WHERE user_name LIKE #{cari}")
    @Results(value= {
    		@Result(property = "id", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "loginId", column = "login_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "active", column = "active"),
            @Result(property = "createdAt", column = "created_at"),
            })
    List<UserModel> cariUser(@Param("cari") String cari);
    
    @Select("SELECT user_id,user_name,login_id, CASE WHEN active = 1 THEN \"Active\" ELSE \"Non Active\" END AS status,active, DATE_FORMAT(created_at, '%D %M %Y') as created_at FROM user WHERE created_at BETWEEN #{createdAt} AND #{createdAt2}")
    @Results(value= {
    		@Result(property = "id", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "loginId", column = "login_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "active", column = "active"),
            @Result(property = "createdAt", column = "created_at"),
            })
    List<UserModel> ambilSemuaByDate( @Param("createdAt")  String createdAt,@Param("createdAt2") String createdAt2);
    
}
