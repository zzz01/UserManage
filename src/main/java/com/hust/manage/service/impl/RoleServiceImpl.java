package com.hust.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.manage.dao.PowerDao;
import com.hust.manage.dao.RoleDao;
import com.hust.manage.dao.RolePowerDao;
import com.hust.manage.dao.UserRoleDao;
import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.model.RolePower;
import com.hust.manage.model.UserRole;
import com.hust.manage.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PowerDao powerDao;
	@Autowired
	private RolePowerDao rolePowerDao;
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public List<Role> selectAllRole(int pageStart, int pageLimit) {
		List<Role> role = roleDao.selectAllRole(pageStart, pageLimit);
		return role;
	}

	@Override
	public boolean insertRole(String roleName) {
		List<Role> role = roleDao.selectByOtherdRoleByRoleName(roleName);
		for (Role roleInfo : role) {
			if (roleInfo.getRolename().equals(roleName)) {
				logger.info("insert roleName is exist");
				return false;
			}
		}
		int status = roleDao.insertRole(roleName);
		if (status == 0) {
			logger.info("insert role is error");
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteRoleById(int roleId) {
		List<UserRole> userRole = userRoleDao.selectUserRoleByRoleId(roleId);
		// 先删除和角色相关的用户相关信息
		if (!userRole.isEmpty() || userRole.size() != 0) {
			for (UserRole userRoleInfo : userRole) {
				int statue = userRoleDao.deleteUserRoleById(userRoleInfo.getId());
				if (statue == 0) {
					logger.info("delete userRole is error");
					return false;
				}
			}
		}
		// 删除和角色相关的权限
		List<RolePower> rolePowers = rolePowerDao.selectRolePowerByRoleId(roleId);
		if (!rolePowers.isEmpty()) {
			for (RolePower rolePowerInfo : rolePowers) {
				int status = rolePowerDao.deleteByPrimaryKey(rolePowerInfo.getId());
				if (status == 0) {
					logger.info("delete rolePower by id is error");
					return false;
				}
			}
		}
		int statusOfRole = roleDao.deleteByPrimaryKey(roleId);
		if (statusOfRole == 0) {
			logger.info("delete role by id  is error");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateRole(Role role, List<String> powerName) {
		List<Role> oldRole = roleDao.selectRoleById(role.getId());
		List<Role> otherRole = roleDao.selectByOtherdRoleByRoleName(oldRole.get(0).getRolename());
		for (Role roleInfo : otherRole) {
			if (roleInfo.getRolename().equals(role.getRolename())) {
				logger.info("update roleName is exist");
				return false;
			}
		}
		int status = roleDao.updateByPrimaryKey(role);
		if (status == 0) {
			logger.info("update role is error");
			return false;
		}
		List<RolePower> rolePowers = rolePowerDao.selectRolePowerByRoleId(role.getId());
		List<Integer> oldPowers = new ArrayList<Integer>();
		for (RolePower powers : rolePowers) {
			oldPowers.add(powers.getId());
		}
		List<Integer> newPowers = new ArrayList<Integer>();
		if (!powerName.isEmpty()) {
			for (String powerNameInfo : powerName) {
				List<Power> powers = powerDao.selectPowerByPowerName(powerNameInfo);
				newPowers.add(powers.get(0).getId());
			}
		} else {
			logger.info("power update is empty");
		}
		// oldPowers newPowers
		for (int powerInfo : oldPowers) {
			// 删除
			if (!newPowers.contains(powerInfo)) {
				int statusOfRolePower = rolePowerDao.deleteRolePowerById(powerInfo, role.getId());
				if (statusOfRolePower == 0) {
					logger.info("delete rolePower is error");
					return false;
				}
			}
		}
		for (int powerInfo : newPowers) {
			// 添加
			if (!oldPowers.contains(powerInfo)) {
				RolePower rolePower = new RolePower();
				rolePower.setPoweId(powerInfo);
				rolePower.setRoleId(role.getId());
				int statusOfRolePower = rolePowerDao.insert(rolePower);
				if (statusOfRolePower == 0) {
					logger.info("insert rolepower is error");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public List<Power> includePower(int roleId) {
		List<Integer> powerIds = new ArrayList<Integer>();
		List<Power> includePower = new ArrayList<Power>();
		List<RolePower> rolePowers = rolePowerDao.selectRolePowerByRoleId(roleId);
		if (rolePowers.isEmpty() || rolePowers.size() == 0) {
			logger.info("role not distribution power");
			return includePower;
		}
		for (RolePower rolePowerInfo : rolePowers) {
			powerIds.add(rolePowerInfo.getPoweId());
		}
		includePower = powerDao.selectPowerByPowerId(powerIds);
		return includePower;
	}

	@Override
	public List<Role> selectRoleByName(String roleName) {
		List<Role> role = roleDao.selectRoleByName(roleName);
		return role;
	}

	@Override
	public List<Role> selectAllRole() {
		List<Role> role = roleDao.selectAllRole();
		return role;
	}
}