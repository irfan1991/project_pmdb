package com.projectpmdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectpmdb.dao.RoleMapper;
import com.projectpmdb.dao.UserMapper;
import com.projectpmdb.dao.UserRoleMapper;
import com.projectpmdb.domain.UserPrincipal;
import com.projectpmdb.model.RoleModel;
import com.projectpmdb.model.UserModel;
import com.projectpmdb.model.UserRoleModel;


@Service
public class UserServiceDatabase implements UserDetailsService , UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
    private RoleMapper roleMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserModel findUserByLoginId(String loginId) {
		return userMapper.findUserByLoginId(loginId);
	}
	
	public void saveUser(UserModel user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        userMapper.setUserInfo(user);

        RoleModel role = roleMapper.getRoleInfo("ADMIN");

		UserRoleModel userRole = new UserRoleModel();
		userRole.setRoleId(role.getId());
		userRole.setUserId(user.getId());

		userRoleMapper.setUserRoleInfo(userRole);
	}

	  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userMapper.findUserByLoginId(username);
		return new UserPrincipal(user);
	}

	@Override
	public List<UserModel> selectAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectSemuaUser();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUserMapper(id);
	}

	@Override
	public UserModel getEdit(int id) {
		// TODO Auto-generated method stub
		return userMapper.getEditMapper(id);
	}

	@Override
	public void updateUser(UserModel userModel) {
		// TODO Auto-generated method stub
		userMapper.updateUserMapper(userModel);
	}

	@Override
	public UserModel getView(int id) {
		// TODO Auto-generated method stub
		return userMapper.getViewMapper(id);
	}

	@Override
	public void updatePassword(UserModel userModel) {
		// TODO Auto-generated method stub
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userMapper.updatePasswordMapper(userModel);
	}

	@Override
	public List<UserModel> cariNamaUser(String cari) {
		// TODO Auto-generated method stub
		return userMapper.cariUser('%'+cari+'%');
	}

	@Override
	public List<UserModel> searchDate(String createdAt, String createdAt2) {
		// TODO Auto-generated method stub
		return userMapper.ambilSemuaByDate(createdAt, createdAt2);
	}

}
