package com.hust.manage.service;

import java.util.List;

import com.hust.manage.model.Power;

public interface PowerService {

	List<Power> selectAllPower(int pageStart, int pageLimit);

	boolean insertPower(Power power);

	boolean deletePowerById(int powerId);

	boolean updatePower(Power power);
}
