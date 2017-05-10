package com.hust.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hust.manage.model.Role;
import com.hust.manage.model.User;
import com.hust.manage.model.condition.UserQueryCondition;

public interface UserService {

	List<User> selectAllUser(int pageStart, int pageLimit, HttpServletRequest request);

	boolean deleteUserById(int userId, HttpServletRequest request);

	boolean updateUser(User user, List<String> roleName);

	boolean insertUser(User user, List<String> roleName);

	// boolean login(String userName, String password);

	// void logout(HttpServletRequest request);

	// 查询用户包含的权限信息
	List<String> selectUserPowerUrl(String userName);

	long countOfUser();

	List<User> selectUserByCondition(UserQueryCondition userQueryCondition);

	// String getCurrentUser(HttpServletRequest request);

	// boolean insertUser(User user);
}
