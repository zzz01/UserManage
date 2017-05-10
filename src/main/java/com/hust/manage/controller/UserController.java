package com.hust.manage.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.manage.model.Role;
import com.hust.manage.model.User;
import com.hust.manage.model.UserRole;
import com.hust.manage.model.condition.UserQueryCondition;
import com.hust.manage.service.RoleService;
import com.hust.manage.service.UserRoleService;
import com.hust.manage.service.UserService;
import com.hust.manage.util.ResultUtil;
import com.hust.manage.util.TimeUtil;

@Controller("user")
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;

	@ResponseBody
	@RequestMapping(value = "/getUserInfo")
	public User getUserInfo() {
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/selectAllUser")
	public Object selectAllUser(@RequestParam(value = "pageStart", required = true) int pageStart,
			@RequestParam(value = "pageLimit", required = true) int pageLimit, HttpServletRequest request) {
		List<User> user = userService.selectAllUser(pageStart, pageLimit, request);
		if (user == null || user.size() == 0) {
			return ResultUtil.errorWithMsg("user table is empty");
		}
		List<Role> roles = roleService.selectAllRole();
		if (null == roles || roles.size() == 0) {
			return ResultUtil.errorWithMsg("select all role empty");
		}
		List<UserRole> userRole = userRoleService.selectUserRole();
		if (userRole == null || userRole.size() == 0) {
			return ResultUtil.errorWithMsg("select userRole empty");
		}
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("user", user);
		result.put("roles", roles);
		result.put("userRole", userRole);
		return ResultUtil.success(result);
	}

	@ResponseBody
	@RequestMapping("/deleteUserInfoById")
	public Object deleteUserInfoById(@RequestParam(value = "userId", required = true) int userId,
			HttpServletRequest request) {
		boolean status = userService.deleteUserById(userId, request);
		if (status == false) {
			return ResultUtil.errorWithMsg("delete users error");
		}
		return ResultUtil.success("delete user success");
	}

	@ResponseBody
	@RequestMapping("/updateUserInfo")
	public Object updateUseInfo(@RequestBody User user,
			@RequestParam(value = "roleName", required = true) List<String> roleName, HttpServletRequest request) {
		try {
			user.setCreatedate(TimeUtil.getSystemDate());
		} catch (ParseException e) {
			logger.info("get systemdate error");
			e.printStackTrace();
		}
		boolean status = userService.updateUser(user, roleName);
		if (status == false) {
			return ResultUtil.errorWithMsg("update user error ");
		}
		return ResultUtil.success("update user success");
	}

	@ResponseBody
	@RequestMapping("/insertUserInfo")
	public Object insertUserInfo(@RequestBody User user,
			@RequestParam(value = "roleName", required = true) List<String> roleName, HttpServletRequest request) {
		try {
			user.setCreatedate(TimeUtil.getSystemDate());
		} catch (ParseException e) {
			logger.info("get systemdate is error ");
			e.printStackTrace();
		}
		boolean status = userService.insertUser(user, roleName);
		if (status == false) {
			return ResultUtil.errorWithMsg("insert userinfo error ");
		}
		return ResultUtil.success("insert user success");
	}

	@ResponseBody
	@RequestMapping("/count")
	public Object count() {
		long numbers = userService.countOfUser();
		return numbers;
	}

	@ResponseBody
	@RequestMapping(value = "/getUserInfoByPageLimit", method = RequestMethod.POST)
	public Object getUserInfoByCondition(@RequestBody UserQueryCondition userQueryCondition,
			@RequestParam(value = "pageStart", required = true) int page,
			@RequestParam(value = "pageLimit", required = true) int row, HttpServletRequest request) {
		List<User> userInfo = userService.selectUserByCondition(userQueryCondition);
		List<Role> roles = roleService.selectAllRole();
		if (null == roles || roles.size() == 0) {
			return ResultUtil.errorWithMsg("select all role empty");
		}
		List<UserRole> userRole = userRoleService.selectUserRole();
		if (userRole.isEmpty() || userRole.size() == 0) {
			return ResultUtil.errorWithMsg("select userRole empty");
		}
		if (null == userInfo || userInfo.size() == 0) {
			return ResultUtil.errorWithMsg("select userInfo empty");
		}
		Map<Object, Object> map = new HashMap<>();
		map.put("userQueryCondition", userInfo);
		map.put("role", roles);
		map.put("userRole", userRole);
		return ResultUtil.success(map);
	}
}
