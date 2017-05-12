package com.hust.manage.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.manage.dao.mapper.UserMapper;
import com.hust.manage.model.User;
import com.hust.manage.model.UserExample;
import com.hust.manage.model.UserExample.Criteria;
import com.hust.manage.model.condition.UserQueryCondition;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;

	public User getUserInfoById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public List<User> checkLogin(String userName, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andUserPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	public List<User> selectAllUserInfo() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	public List<User> selectByCondition(UserQueryCondition userQueryCondition) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(userQueryCondition.getUserName())) {
			criteria.andUserNameEqualTo(userQueryCondition.getUserName());
		}
		if (!StringUtils.isBlank(userQueryCondition.getUserTruename())) {
			criteria.andUserTruenameEqualTo(userQueryCondition.getUserName());
		}
		if (!StringUtils.isBlank(userQueryCondition.getUserAddress())) {
			criteria.andUserAddressEqualTo(userQueryCondition.getUserAddress());
		}
		if (!StringUtils.isBlank(userQueryCondition.getUserTel())) {
			criteria.andUserTelEqualTo(userQueryCondition.getUserTel());
		}
		example.setPageLimit(userQueryCondition.getPageLimit());
		example.setPageStart(userQueryCondition.getPageStart());
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	public List<User> selectAllUser(int pageStart, int pageLimit) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		example.setPageStart(pageStart);
		example.setPageLimit(pageLimit);
		List<User> user = userMapper.selectByExample(example);
		return user;

	}

	public List<User> selectByUserName(String userName) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	public List<User> selectBynotIncluedUserName(String userName) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameNotEqualTo(userName);
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	public List<User> selectByLikeUserName(String userName) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameLike("%" + userName + "%");
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

	public long selectCountOfUser() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		long count = userMapper.countByExample(example);
		return count;
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public long countByExample(UserExample example) {
		return userMapper.countByExample(example);
	}

	public int deleteByExample(UserExample example) {
		return userMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	public int insert(User record) {
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public int updateByExampleSelective(User record, UserExample example) {
		return userMapper.updateByExample(record, example);
	}

	public int updateByExample(User record, UserExample example) {
		return userMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

}
