package com.hust.manage.shiro.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hust.manage.constant.RightConst;
import com.hust.manage.constant.WebConst;
import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.model.User;
import com.hust.manage.model.condition.RoleAndPower;
import com.hust.manage.service.UserService;
import com.hust.manage.shiro.session.DbSession;
import com.hust.manage.util.ServletUtil;
import com.hust.manage.util.StatusEnvelope;

public class UserCasFilter extends UserFilter implements RightConst {

	private static final Logger logger = LoggerFactory.getLogger(UserCasFilter.class);
	@Autowired
	private UserService userService;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String sessionId = ServletUtil.cookieVal(httpRequest, WebConst.COOKIE_SESSION);
		if (StringUtils.isBlank(sessionId)) {
			StatusEnvelope.forbidden("未登录");
			logger.info("未登录");
			return false;
		}

		List<User> user = userService.selectUserByUserName(WebConst.COOKIE_SESSION);
		if (user.isEmpty()) {
			StatusEnvelope.notFound("用户不存在");
			logger.info("用户不存在");
			return false;
		}
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			if (!shiroLogin(sessionId, subject, httpRequest, httpResponse)) {
				StatusEnvelope.forbidden("登陆失败！");
				return false;
			}
			return false;
		}

		User userInfo = (User) subject.getPrincipal();
		if (userInfo == null || !userInfo.getUserName().equals(sessionId)) {
			subject.logout();
		}
		return true;
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
		String sessionId = subject.getSession().getId().toString();
		Cookie ssoCookie = new Cookie(WebConst.COOKIE_SESSION, userName);

		String path = request.getContextPath();
		path = "".equals(path) ? "/" : path;
		ssoCookie.setPath(path);
		ssoCookie.setHttpOnly(true);
		response.addCookie(ssoCookie);

		Cookie d2SessionId = new Cookie(WebConst.COOKIE_DBSESSION, sessionId);
		d2SessionId.setPath(path);
		d2SessionId.setHttpOnly(true);
		response.addCookie(d2SessionId);
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return super.onAccessDenied(request, response);
	}

}
