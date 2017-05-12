package com.hust.manage.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hust.manage.constant.RightConst;
import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.model.User;
import com.hust.manage.model.condition.RoleAndPower;
import com.hust.manage.service.UserService;
import com.hust.manage.shiro.session.DbSession;

/**
 * 获取安全数据（如用户、角色、权限） SecurityManager 要验证用户身份，就需要从realm获取相应的用户进行比较以确定用户身份是否合法
 * 安全数据源
 * 
 * @author shixi_zhizhao
 *
 */
public class ShiroDbRealm extends AuthorizingRealm implements RightConst {

	@Autowired
	private UserService userService;

	/**
	 * 授权，即权限验证，验证某个已认证的用户是否拥有某个权限，即判断用户是否能做某个事，例如：验证某个用户是否具有某个角色
	 * 假如以角色来判断用户具有的权限，可以验证角色，假如以访问的资源来判断权限，则需要进行细粒度分析。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		DbSession dbSession = new DbSession();
		List<Power> powerList = dbSession.getPowerList();
		List<Role> roleList = dbSession.getRoleList();
		if (powerList == null || roleList == null) {
			User user = dbSession.getUser();
			if (user != null) {
				RoleAndPower roleAndPower = userService.selectRoleAndPowerByUserName(user.getUserName());
				powerList = roleAndPower.getPowerList();
				roleList = roleAndPower.getRoleList();
				dbSession.put(PERMISSION_LIST, powerList);
				dbSession.put(ROLE_LIST, roleList);
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> roleName = new ArrayList<String>();
		for (Role roleInfo : roleList) {
			roleName.add(roleInfo.getRolename());
		}
		List<String> powerName = new ArrayList<String>();
		for (Power powerInfo : powerList) {
			powerName.add(powerInfo.getPowerUrl());
		}
		info.addRoles(roleName);
		info.addStringPermissions(powerName);
		return info;
	}

	/**
	 * 身份认证/登录，验证用户是不是拥有相应的身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = upt.getUsername();
		if (userName == null || StringUtils.isBlank(userName)) {
			return null;
		}
		List<User> user = userService.selectUserByUserName(userName);
		if (!user.isEmpty()) {
			return new SimpleAuthenticationInfo(user, "DEFAULT".toCharArray(), getName());
		} else {
			return null;
		}
	}
}
