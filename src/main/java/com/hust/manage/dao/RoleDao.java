package com.hust.manage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.manage.dao.mapper.RoleMapper;
import com.hust.manage.model.Role;
import com.hust.manage.model.RoleExample;
import com.hust.manage.model.RoleExample.Criteria;

@Repository
public class RoleDao {

	@Autowired
	private RoleMapper roleMapper;

	public long countByExample(RoleExample example) {
		return roleMapper.countByExample(example);
	}


	public List<Role> selectRole() {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<Role> roles = roleMapper.selectByExample(example);
		return roles;
	}

	public List<Role> selectRoleById(int roleId) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(roleId);
		List<Role> roles = roleMapper.selectByExample(example);
		return roles;
	}

	public List<Role> selectRoleByName(String roleName) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolenameEqualTo(roleName);
		List<Role> roles = roleMapper.selectByExample(example);
		return roles;
	}

	public List<Role> selectByNotIncluedRoleName(String roleName) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolenameNotEqualTo(roleName);
		List<Role> roles = roleMapper.selectByExample(example);
		return roles;
	}

	public int deleteByExample(RoleExample example) {
		return roleMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer roleId) {
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	public int insertRole(String roleName) {
		Role roles = new Role();
		roles.setRolename(roleName);
		return roleMapper.insert(roles);
	}

	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	public List<Role> selectByExample(RoleExample example) {
		return roleMapper.selectByExample(example);
	}

	public Role selectByPrimaryKey(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	public int updateByExampleSelective(Role record, RoleExample example) {
		return roleMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Role record, RoleExample example) {
		return roleMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

}
