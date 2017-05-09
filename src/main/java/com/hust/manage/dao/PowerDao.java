package com.hust.manage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.manage.dao.mapper.PowerMapper;
import com.hust.manage.model.Power;
import com.hust.manage.model.PowerExample;
import com.hust.manage.model.PowerExample.Criteria;

@Repository
public class PowerDao {

	@Autowired
	private PowerMapper powerMapper;

	public List<Power> selectPowerById(int powerId) {
		PowerExample example = new PowerExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(powerId);
		List<Power> powers = powerMapper.selectByExample(example);
		return powers;
	}

	public List<Power> selectPowerByPowerId(List<Integer> powerIds) {
		PowerExample example = new PowerExample();
		// 查询不出来用户的所有权限
		for (int powerId : powerIds) {
			Criteria criterias = example.createCriteria();
			criterias.andIdEqualTo(powerId);
			example.or(criterias);
		}
		List<Power> powers = powerMapper.selectByExample(example);
		return powers;
	}

	public List<Power> selectPowerByPowerName(String powerName) {
		PowerExample example = new PowerExample();
		Criteria criteria = example.createCriteria();
		criteria.andPowerNameEqualTo(powerName);
		List<Power> powers = powerMapper.selectByExample(example);
		return powers;
	}

	public List<Power> selectAllPowers() {
		PowerExample example = new PowerExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<Power> powers = powerMapper.selectByExample(example);
		return powers;
	}

	public long countByExample(PowerExample example) {
		return powerMapper.countByExample(example);
	}

	public int deleteByExample(PowerExample example) {
		return powerMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer powerId) {
		return powerMapper.deleteByPrimaryKey(powerId);
	}

	public int insert(Power record) {
		return powerMapper.insert(record);
	}

	public int insertSelective(Power record) {
		return powerMapper.insertSelective(record);
	}

	public List<Power> selectByExample(PowerExample example) {
		return powerMapper.selectByExample(example);
	}

	public Power selectByPrimaryKey(Integer powerId) {
		return powerMapper.selectByPrimaryKey(powerId);
	}

	public int updateByExampleSelective(Power record, PowerExample example) {
		return powerMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Power record, PowerExample example) {
		return powerMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Power record) {
		return powerMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Power record) {
		return powerMapper.updateByPrimaryKey(record);
	}

}
