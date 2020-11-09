package com.projectpmdb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.projectpmdb.model.RoleModel;

@Component
@Mapper
public interface RoleMapper {
	RoleModel getRoleInfo(@Param("role") String role);
}
