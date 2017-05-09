package com.hust.manage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.manage.dao.mapper.UserRoleMapper;
import com.hust.manage.model.UserRole;
import com.hust.manage.model.UserRoleExample;
import com.hust.manage.model.UserRoleExample.Criteria;

@Repository
public class UserRoleDao {

	@Autowired
	private UserRoleMapper userRoleMapper;
	public List<UserRole> selectAllUserRole() {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		return userRoles;
	}

	public int deleteUserRoleByUserId(int id) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		int statue = userRoleMapper.deleteByExample(example);
		return statue;
	}

	public List<UserRole> selectUserRoleByUserId(int userId) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserRole> userRole = userRoleMapper.selectByExample(example);
		return userRole;
	}

	public List<UserRole> selectUserRoleByRoleId(int roleId) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<UserRole> userRole = userRoleMapper.selectByExample(example);
		return userRole;
	}

	public int insertUserRole(UserRole userRole) {
		int status = userRoleMapper.insertSelective(userRole);
		return status;
	}

	public int deleteUserRoleByRoleId(int roleId) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		int statue = userRoleMapper.deleteByExample(example);
		return statue;
	}

}
