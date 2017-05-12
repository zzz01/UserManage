package com.hust.manage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.manage.constant.RightConst;
import com.hust.manage.constant.WebConst;
import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.model.condition.RoleAndPower;
import com.hust.manage.service.UserService;
import com.hust.manage.shiro.session.DbSession;
import com.hust.manage.util.ResultUtil;

@Controller
@RequestMapping("/Auth")
public class AuthController implements RightConst, WebConst {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login")
	public Object login(@RequestParam(value = "username", required = true) String userName,
			@RequestParam(value = "password", required = true) String passwd, HttpServletResponse response,
			HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (shiroLogin(userName, subject, request, response)) {
			String sessionId = subject.getSession().getId().toString();
			Cookie ssoCookie = new Cookie(WebConst.COOKIE_SESSION, String.valueOf(userName));

			String path = request.getContextPath();
			path = "".equals(path) ? "/" : path;
			ssoCookie.setPath(path);
			ssoCookie.setHttpOnly(true);
			response.addCookie(ssoCookie);

			Cookie d2SessionId = new Cookie(WebConst.COOKIE_DBSESSION, sessionId);
			d2SessionId.setPath(path);
			d2SessionId.setHttpOnly(true);
			response.addCookie(d2SessionId);
			return ResultUtil.successWithOutMsg();
		}
		// 添加缓存
		return ResultUtil.errorWithMsg("用户名密码错误");
	}

	@ResponseBody
	@RequestMapping(value = "/logout")
	public Object logout(HttpServletRequest request) {
		// 缓存移除
		return ResultUtil.successWithOutMsg();
	}

	private boolean shiroLogin(String userName, Subject subject, HttpServletRequest request,
			HttpServletResponse response) {
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(userName);
		token.setPassword("DEFAULT".toCharArray());
		token.setHost(null);
		token.setRememberMe(false);
		try {
			subject.login(token);
		} catch (Exception e) {
			return false;
		}
		RoleAndPower roleAndPower = userService.selectRoleAndPowerByUserName(userName);
		List<Role> roleList = new ArrayList<Role>();
		List<Power> powerList = new ArrayList<Power>();
		roleList = roleAndPower.getRoleList();
		powerList = roleAndPower.getPowerList();
		DbSession dbSession = new DbSession();
		dbSession.put(ROLE_LIST, roleList);
		dbSession.put(PERMISSION_LIST, powerList);

		return true;
	}
}
