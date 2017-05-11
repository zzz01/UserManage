package com.hust.manage.shiro.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.hust.manage.constant.RightConst;
import com.hust.manage.model.Power;
import com.hust.manage.model.Role;
import com.hust.manage.model.User;

public class DbSession implements Map<String, Object>, Serializable, RightConst {
	private static final long serialVersionUID = 6247483137999842795L;

	private Session session;

	public DbSession() {
		Subject subject = SecurityUtils.getSubject();
		this.session = subject.getSession();
	}

	@SuppressWarnings("unchecked")
	public List<Role> getRoleList() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		return (List<Role>) session.getAttribute(ROLE_LIST);
	}

	@SuppressWarnings("unchecked")
	public List<Power> getPowerList() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		return (List<Power>) session.getAttribute(PERMISSION_LIST);
	}

	public User getUser() {
		Subject subject = SecurityUtils.getSubject();
		return (User) subject.getPrincipal();
	}

	@Override
	public int size() {
		Collection<Object> keys = session.getAttributeKeys();
		return (keys == null) ? 0 : keys.size();
	}

	@Override
	public boolean isEmpty() {
		Collection<Object> keys = session.getAttributeKeys();
		return keys == null || keys.size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return get((String) key) != null;

	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Object get(Object key) {
		return session.getAttribute((String) key);
	}

	@Override
	public Object put(String key, Object value) {
		session.setAttribute((String) key, value);
		return value;
	}

	@Override
	public Object remove(Object key) {
		return session.removeAttribute((String) key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		for (Map.Entry<? extends String, ? extends Object> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void clear() {
		Collection<Object> keys = session.getAttributeKeys();
		for (Object key : keys) {
			session.removeAttribute(key);
		}
	}

	@Override
	public Set<String> keySet() {
		Collection<Object> keys = session.getAttributeKeys();
		Map<String, Object> map = new HashMap<String, Object>();
		if (keys != null && keys.size() > 0) {
			for (Object key : keys) {
				map.put((String) key, session.getAttribute(key));
			}
		}
		return map.keySet();
	}

	@Override
	public Collection<Object> values() {
		return session.getAttributeKeys();
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		Collection<Object> keys = session.getAttributeKeys();
		Map<String, Object> map = new HashMap<String, Object>();
		if (keys != null && keys.size() > 0) {
			for (Object key : keys) {
				map.put((String) key, session.getAttribute(key));
			}
		}
		return map.entrySet();
	}

}
