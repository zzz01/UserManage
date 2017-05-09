package com.hust.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.manage.model.User;
import com.hust.manage.service.UserService;

@Controller("user")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/getUserInfo")
	public User getUserInfo() {
		User user = userService.getUserById(1);
		return user;
	}
}
