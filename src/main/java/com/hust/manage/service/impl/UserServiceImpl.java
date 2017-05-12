package com.hust.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.hust.manage.dao.PowerDao;
import com.hust.manage.dao.RoleDao;
import com.hust.manage.dao.RolePowerDao;
import com.hust.manage.dao.UserDao;
import com.hust.manage.dao.UserRoleDao;
import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.model.RolePower;
import com.hust.manage.model.User;
import com.hust.manage.model.UserRole;
import com.hust.manage.model.condition.RoleAndPower;
import com.hust.manage.model.condition.UserQueryCondition;
import com.hust.manage.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RolePowerDao rolePowerDao;
	@Autowired
	private PowerDao powerDao;

	public User getUserById(int userId) {
		return userDao.getUserInfoById(userId);
	}

	@Override
	@Description("查询所有用户信息，并实现分页查询")
	public List<User> selectAllUser(int pageStart, int pageLimit, HttpServletRequest request) {
		List<User> userInfo = userDao.selectAllUser(pageStart, pageLimit);
		return userInfo;
	}

	@Override
	@Description("通过ID删除用户")
	public boolean deleteUserById(int userId, HttpServletRequest request) {
		List<UserRole> userRole = userRoleDao.selectUserRoleByUserId(userId);
		List<Integer> id = new ArrayList<>();
		for (UserRole userRoleInfo : userRole) {
			id.add(userRoleInfo.getId());
		}
		for (int idInfo : id) {
			int status = userRoleDao.deleteUserRoleById(idInfo);
			if (status == 0) {
				logger.info("delete userRoleById is error");
				return false;
			}
		}
		int status = userDao.deleteByPrimaryKey(userId);
		if (status == 0) {
			logger.info("delete userById is error ");
			return false;
		}
		return true;
	}

	@Override
	@Description("更新用户信息")
	public boolean updateUser(User user, List<String> roleName) {
		User userInfo = userDao.selectByPrimaryKey(user.getId());
		List<User> users = userDao.selectBynotIncluedUserName(userInfo.getUserName());
		// 用户名唯一性判断
		for (User userInfos : users) {
			if (userInfos.getUserName().equals(user.getUserName())) {
				logger.info("update userName is exist");
				return false;
			}
		}
		int status = userDao.updateByPrimaryKey(user);
		if (status == 0) {
			logger.info("update User is error");
			return false;
		}
		// 通过用户ID获取用户角色信息，目的是为了获取 用户所具有的角色ID。
		List<UserRole> userRoles = userRoleDao.selectUserRoleByUserId(user.getId());
		// 存放数据库中已经存在 角色ID
		List<Integer> roleIdInfo = new ArrayList<Integer>();
		for (UserRole userRoleInfo : userRoles) {
			roleIdInfo.add(userRoleInfo.getRoleId());
		}
		// 获取更新信息中角色ID
		List<Integer> roleIds = new ArrayList<Integer>();
		for (String roleNameInfo : roleName) {
			List<Role> role = roleDao.selectRoleByName(roleNameInfo);
			roleIds.add(role.get(0).getId());
		}
		// 通过对比更新信息中角色ID和数据库中角色ID，来判断对角色的增加还是删除
		for (int roleId : roleIdInfo) {
			// 如果更新信息中不包含数据库中已经存在的角色信息，则进行数据删除；
			if (!roleIds.contains(roleId)) {
				int statusOfUserRole = userRoleDao.deleteUserRoleByRoleId(roleId);
				if (statusOfUserRole == 0) {
					logger.info("delete userRole by roleId is error");
					return false;
				}
			}
		}
		// 如果数据库中信息不包括更新信息中角色信息，则为用户添加相应的角色信息
		for (int roleId : roleIds) {
			// 如果数据库中不存在更新信息的角色，则进行增加
			if (!roleIdInfo.contains(roleId)) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(user.getId());
				int statusOfUserRole = userRoleDao.insertUserRole(userRole);
				if (statusOfUserRole == 0) {
					logger.info("insert role for user is error");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean insertUser(User user, List<String> roleName) {
		List<User> insertUser = userDao.selectByUserName(user.getUserName());
		if (!insertUser.isEmpty()) {
			logger.info("user table has same as userName");
			return false;
		}
		int status = userDao.insert(user);
		if (status == 0) {
			logger.info("insert user error ");
			return false;
		}
		// 上面是添加用户信息成功，现在需要取出用户ID, 然后根据角色名称取出角色ID，然后再把相应的信息添加到userRole表中
		List<Integer> roleId = new ArrayList<>();
		for (String roleNameInfo : roleName) {
			roleId.add(roleDao.selectRoleByName(roleNameInfo).get(0).getId());
		}
		int userId = insertUser.get(0).getId();
		for (int roleIdInfo : roleId) {
			UserRole userRole = new UserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(roleIdInfo);
			int statusOfUserRole = userRoleDao.insertUserRole(userRole);
			if (statusOfUserRole == 0) {
				logger.info("insert userRole is error");
				return false;
			}
		}
		return true;
	}

	@Override
	public List<String> selectUserPowerUrl(String userName) {
		List<String> powerUrls = new ArrayList<>();
		List<Integer> powerId = new ArrayList<>();
		List<User> users = userDao.selectByUserName(userName);
		// 首先用户会有很多角色 所以查询用户拥有的权限的时候，应该去根据用户名 去用户角色表中查找相关的角色Id,
		int userId = users.get(0).getId();
		List<Integer> roleId = new ArrayList<>();
		List<UserRole> userRole = userRoleDao.selectUserRoleByUserId(userId);
		for (UserRole userRoleInfo : userRole) {
			roleId.add(userRoleInfo.getRoleId());
		}
		// 现在得到roleId了，roleId有很多 ，不止一个
		// 也可以先把第一个元素添加进去，然后循环其他的元素，假如roleId>1说明具有很多角色，首先把第一个角色权限信息写进入，然后再循环其他元素假如到的的信息和1不同则添加进去
		// 首先要判断用户到底有几个角色把
		if (roleId.size() == 0) {
			logger.info("用户没有分配角色");
			return powerUrls;
		}
		// 说明用户具有很多个角色
		for (int i = 0; i < roleId.size(); i++) {
			List<RolePower> rolePower = rolePowerDao.selectRolePowerByRoleId(roleId.get(i));
			for (RolePower rolePowerInfo : rolePower) {
				if (!powerId.contains(rolePowerInfo.getId())) {
					powerId.add(rolePowerInfo.getId());
				}
			}
		}
		List<Power> power = powerDao.selectPowerByPowerId(powerId);
		for (Power powerInfo : power) {
			powerUrls.add(powerInfo.getPowerUrl());
		}
		return powerUrls;
	}

	@Override
	public long countOfUser() {
		long numbers = userDao.selectCountOfUser();
		return numbers;
	}

	@Override
	public List<User> selectUserByCondition(UserQueryCondition userQueryCondition) {
		List<User> users = userDao.selectByCondition(userQueryCondition);
		List<User> user = new ArrayList<User>();
		// 对查询出来的信息进行筛选 首先需要根据条件 查出roleId，再根据ID 查出所有的用户ID，然后去判断
		if (!userQueryCondition.getRoleName().isEmpty()) {
			List<Role> roles = roleDao.selectRoleByName(userQueryCondition.getRoleName());
			List<UserRole> userRoles = userRoleDao.selectUserRoleByRoleId(roles.get(0).getId());
			for (User userInfo : users) {
				for (UserRole userRoleInfo : userRoles) {
					if (userInfo.getId().equals(userRoleInfo.getUserId())) {
						user.add(userInfo);
					}
				}
			}
		} else {
			user = users;
		}
		return users;
	}

	@Override
	public List<User> selectUserByUserName(String userName) {
		List<User> user = userDao.selectByUserName(userName);
		return user;
	}

	@Override
	public RoleAndPower selectRoleAndPowerByUserName(String userName) {
		List<User> user = userDao.selectByUserName(userName);
		List<UserRole> userRole = userRoleDao.selectUserRoleByUserId(user.get(0).getId());
		List<Role> roleList = new ArrayList<Role>();
		List<Integer> roleId = new ArrayList<Integer>();
		for (UserRole userRoleInfo : userRole) {
			roleId.add(userRoleInfo.getRoleId());
			Role role = roleDao.selectByPrimaryKey(userRoleInfo.getRoleId());
			roleList.add(role);
		}
		List<Power> powerList = new ArrayList<Power>();
		List<RolePower> rolePower = rolePowerDao.selectRolePowerByRoleId(roleId);
		for (RolePower rolePowerInfo : rolePower) {
			Power power = powerDao.selectByPrimaryKey(rolePowerInfo.getPoweId());
			if (!powerList.contains(power)) {
				powerList.add(power);
			}
		}
		RoleAndPower roleAndPower = new RoleAndPower();
		roleAndPower.setPowerList(powerList);
		roleAndPower.setRoleList(roleList);
		return roleAndPower;
	}

	@Override
	public boolean login(String userName, String password) {
		List<User> users = userDao.checkLogin(userName, password);
		if (null == users || users.size() == 0) {
			logger.info("username or password is incorrect");
			return false;
		}
		return true;
	}
}
