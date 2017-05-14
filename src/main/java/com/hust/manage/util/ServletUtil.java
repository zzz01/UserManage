package com.hust.manage.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ServletUtil {

	public static String cookieVal(HttpServletRequest request, String name) {
		Cookie[] cookie = request.getCookies();
		if (cookie != null && cookie.length > 0) {
			for (Cookie cookieInfo : cookie) {
				if (cookieInfo.getName().equals(name)) {
					return cookieInfo.getValue();
				}
			}
		}
		return null;

	}
}
