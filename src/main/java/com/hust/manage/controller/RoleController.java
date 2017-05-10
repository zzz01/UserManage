package com.hust.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.service.RoleService;
import com.hust.manage.util.ResultUtil;

@Controller
@RequestMapping("/role")
public class RoleController {
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping(value = "/selectAllRole")
	public Object selectAllRole(@RequestParam(value = "pageStart", required = true) int pageStart,
			@RequestParam(value = "pageLimit", required = true) int pageLimit) {
		List<Role> role = roleService.selectAllRole(pageStart, pageLimit);
		if (role.size() == 0 || role.isEmpty()) {
			logger.info("role is empty or null");
			return ResultUtil.errorWithMsg("role table is empty");
		}
		return ResultUtil.success(role);
	}

	@ResponseBody
	@RequestMapping("/selectAllRoleNoParam")
	public Object selectAllRole() {
		List<Role> role = roleService.selectAllRole();
		if (role.size() == 0 || role.isEmpty()) {
			logger.info("role is empty or null");
		}
		return ResultUtil.success(role);
	}

	@ResponseBody
	@RequestMapping("/selectRoleByName")
	public Object selectRoleByName(@RequestParam(value = "roleName", required = true) String roleName,
			@RequestParam(value = "pageStart", required = true) int pageStart,
			@RequestParam(value = "pageLimit", required = true) int pageLimit, HttpServletRequest request) {
		List<Role> element = roleService.selectRoleByName(roleName);
		if (null == element || element.size() == 0) {
			return ResultUtil.errorWithMsg("rolename not exist");
		}
		return ResultUtil.success(element);
	}

	@ResponseBody
	@RequestMapping("/insertRole")
	public Object insertRole(@RequestParam(value = "roleName", required = true) String roleName,
			HttpServletRequest request) {
		boolean status = roleService.insertRole(roleName);
		if (status == false) {
			return ResultUtil.errorWithMsg("role table have been Role,insert error");
		}
		return ResultUtil.success("insert roleinfo success");
	}

	@ResponseBody
	@RequestMapping("/deleteRoleById")
	public Object deleteRoleById(@RequestParam(value = "roleId", required = true) int roleId,
			HttpServletRequest request) {
		boolean status = roleService.deleteRoleById(roleId);
		if (status == false) {
			return ResultUtil.errorWithMsg("delete role error");
		}
		return ResultUtil.success("delete role success");
	}

	@ResponseBody
	@RequestMapping("/updateRoleInfo")
	public Object updateRoleInfo(@RequestBody Role role,
			@RequestParam(value = "powerName", required = true) List<String> powerName, HttpServletRequest request) {
		boolean status = roleService.updateRole(role, powerName);
		if (status == false) {
			return ResultUtil.errorWithMsg("update roleinfo error(may be roleInfo has exits),unknow error");
		}
		return ResultUtil.success("update roleInfo success");
	}

	@ResponseBody
	@RequestMapping("/includePowerOfRole")
	public Object includePowersOfRole(@RequestParam(value = "roleId", required = true) int roleId,
			HttpServletRequest request) {
		List<Power> elements = roleService.includePower(roleId);
		if (null == elements || elements.size() == 0) {
			return ResultUtil.errorWithMsg("include powers empty");
		}
		return ResultUtil.success(elements);
	}

}
