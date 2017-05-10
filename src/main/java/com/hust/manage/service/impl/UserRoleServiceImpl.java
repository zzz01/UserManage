package com.hust.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.manage.dao.UserRoleDao;
import com.hust.manage.model.UserRole;
import com.hust.manage.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private UserRoleDao userRoleDao;
	@Override
	public List<UserRole> selectUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
