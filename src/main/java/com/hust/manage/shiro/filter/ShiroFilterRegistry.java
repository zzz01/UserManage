package com.hust.manage.shiro.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

public class ShiroFilterRegistry {
	private Map<String, Filter> filterMap = new HashMap<>();

	public void addShiroFilter(String name, Filter filter) {
		filterMap.put(name, filter);
	}

	public Map<String, Filter> getFilterMap() {
		return filterMap;
	}
}
