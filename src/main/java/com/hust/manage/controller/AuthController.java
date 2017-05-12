package com.hust.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.manage.service.UserService;
import com.hust.manage.util.ResultUtil;

@Controller
@RequestMapping("")
public class AuthController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestParam(value = "username", required = true) String userName,
			@RequestParam(value = "password", required = true) String passwd, HttpServletResponse response,
			HttpServletRequest request) {
		if (userService.login(userName, passwd)) {
			return ResultUtil.successWithOutMsg();
		}
		// 添加缓存
		return ResultUtil.errorWithMsg("用户名密码错误");
	}

	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Object logout(HttpServletRequest request) {
		// 缓存移除
		return ResultUtil.successWithOutMsg();
	}
}
