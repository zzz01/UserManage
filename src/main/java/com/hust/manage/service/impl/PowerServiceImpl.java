package com.hust.manage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.manage.dao.PowerDao;
import com.hust.manage.dao.RolePowerDao;
import com.hust.manage.model.Power;
import com.hust.manage.service.PowerService;

@Service
public class PowerServiceImpl implements PowerService {
	private final static Logger logger = LoggerFactory.getLogger(PowerServiceImpl.class);
	@Autowired
	private PowerDao powerDao;
	@Autowired
	private RolePowerDao rolePowerDao;

	@Override
	public List<Power> selectAllPower(int pageStart, int pageLimit) {
		List<Power> power = powerDao.selectAllPowers(pageStart, pageLimit);
		return power;
	}

	@Override
	public boolean insertPower(Power power) {
		List<Power> powers = powerDao.selectOtherPowerByPowerName(power.getPowerName());
		if (!powers.isEmpty()) {
			for (Power powerInfo : powers) {
				if (powerInfo.getPowerName().equals(power.getPowerName())) {
					logger.info("insert powerName is exist");
					return false;
				}
			}
		}
		int status = powerDao.insert(power);
		if (status == 0) {
			logger.info("insert power is error");
			return false;
		}
		return true;
	}

	@Override
	public boolean deletePowerById(int powerId) {
		int statusOfRolePower = rolePowerDao.deleteRolePowerByPowerId(powerId);
		if (statusOfRolePower == 0) {
			logger.info("role table has this power");
			return false;
		}
		int statusOfPower = powerDao.deleteByPrimaryKey(powerId);
		if (statusOfPower == 0) {
			logger.info("delete power is error in powerTable");
			return false;
		}
		return true;
	}

	@Override
	public boolean updatePower(Power power) {
		List<Power> powers = powerDao.selectOtherPowerByPowerId(power.getId());
		for (Power powerInfo : powers) {
			if (powerInfo.getPowerName().equals(power.getPowerName())) {
				logger.info("powerName is exist");
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Power> selectPowerByLikePowerName(String powerName) {
		List<Power> power = powerDao.selectPowerByLikePowerName(powerName);
		return power;
	}
}