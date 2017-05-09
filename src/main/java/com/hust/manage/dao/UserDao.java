package com.hust.manage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.manage.dao.mapper.UserMapper;
import com.hust.manage.model.User;
import com.hust.manage.model.UserExample;
import com.hust.manage.model.UserExample.Criteria;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;

	public User getUserInfoById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public List<User> selectAllUserInfo() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<User> users = userMapper.selectByExample(example);
		return users;
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
