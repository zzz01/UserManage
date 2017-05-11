package com.hust.manage.shiro.filter;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

public class FormLoginFilter extends PathMatchingFilter {

	@Override
	public Filter processPathConfig(String path, String config) {
		// TODO Auto-generated method stub
		return super.processPathConfig(path, config);
	}

	@Override
	protected String getPathWithinApplication(ServletRequest request) {
		// TODO Auto-generated method stub
		return super.getPathWithinApplication(request);
	}

	@Override
	protected boolean pathsMatch(String path, ServletRequest request) {
		// TODO Auto-generated method stub
		return super.pathsMatch(path, request);
	}

	@Override
	protected boolean pathsMatch(String pattern, String path) {
		// TODO Auto-generated method stub
		return super.pathsMatch(pattern, path);
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response);
	}

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return super.onPreHandle(request, response, mappedValue);
	}

	@Override
	protected boolean isEnabled(ServletRequest request, ServletResponse response, String path, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		return super.isEnabled(request, response, path, mappedValue);
	}

}
