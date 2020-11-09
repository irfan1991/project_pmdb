package com.projectpmdb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.projectpmdb.model.UserModel;
import com.projectpmdb.model.UserRoleModel;

@Component
@Mapper
public interface UserRoleMapper {
	void setUserRoleInfo(@Param("param") UserRoleModel param);
}
