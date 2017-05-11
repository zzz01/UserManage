package com.hust.manage.model.condition;

import java.util.List;

import com.hust.manage.model.Power;
import com.hust.manage.model.Role;

public class RoleAndPower {
	private List<Role> roleList;

	private List<Power> powerList;

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Power> getPowerList() {
		return powerList;
	}

	public void setPowerList(List<Power> powerList) {
		this.powerList = powerList;
	}

}
