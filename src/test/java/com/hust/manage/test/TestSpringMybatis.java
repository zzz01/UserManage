package com.hust.manage.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hust.manage.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestSpringMybatis {
	private static final Logger logger = LoggerFactory.getLogger(TestSpringMybatis.class);

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		System.out.println(userService.getUserById(1).getUserTruename());
	}
}
