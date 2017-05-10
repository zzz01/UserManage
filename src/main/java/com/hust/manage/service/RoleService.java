package com.hust.manage.service;

import java.util.List;

import com.hust.manage.model.Power;
import com.hust.manage.model.Role;

public interface RoleService {

	List<Role> selectAllRole(int pageStart, int pageLimit);
	
	List<Role> selectAllRole();

	List<Role> selectRoleByName(String roleName);

	boolean insertRole(String roleName);

	boolean deleteRoleById(int roleId);

	boolean updateRole(Role role, List<String> powerName);

	// boolean insertPowerOfRole(int roleId, List<String> powerName);

	// boolean deletePowerOfRole(int roleId, List<String> powerName);

	//List<Role> selectNotIncluedRoleOfUser(int roleId);

	// List<Power> notIncludePower(int roleId);

	List<Power> includePower(int roleId);
}
