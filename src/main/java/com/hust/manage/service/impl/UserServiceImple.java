package com.hust.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.manage.dao.UserDao;
import com.hust.manage.model.User;
import com.hust.manage.service.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUserById(int userId) {
		return userDao.getUserInfoById(userId);
	}

}
