package com.hust.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hust.manage.model.User;
import com.hust.manage.model.condition.RoleAndPower;
import com.hust.manage.model.condition.UserQueryCondition;

public interface UserService {

	List<User> selectAllUser(int pageStart, int pageLimit, HttpServletRequest request);

	boolean deleteUserById(int userId, HttpServletRequest request);

	boolean updateUser(User user, List<String> roleName);

	boolean insertUser(User user, List<String> roleName);

	boolean login(String userName, String password);

	// 查询用户包含的权限信息
	List<String> selectUserPowerUrl(String userName);

	List<User> selectUserByUserName(String userName);

	long countOfUser();

	List<User> selectUserByCondition(UserQueryCondition userQueryCondition);

	RoleAndPower selectRoleAndPowerByUserName(String userName);
}
