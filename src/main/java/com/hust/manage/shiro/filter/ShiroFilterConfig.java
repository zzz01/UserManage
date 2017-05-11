package com.hust.manage.shiro.filter;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hust.manage.shiro.config.ShiroFilterRegistry;

@Configuration
@WebAppConfiguration
public class ShiroFilterConfig {
	@Bean
	public ShiroFilterRegistry shiroFilterRegistry() {
		ShiroFilterRegistry registry = new ShiroFilterRegistry();
		registry.addShiroFilter("userCas", userCasFilter());
		return registry;
	}

	@Bean
	public UserCasFilter userCasFilter() {
		return new UserCasFilter();
	}

	@Bean
	public PassThruAuthenticationFilter passThruFilter() {
		return new PassThruAuthenticationFilter();
	}
}
