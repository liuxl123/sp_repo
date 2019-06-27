package com.tedu.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 设置cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void setCookie(HttpServletResponse response,
			String name, String value, String domain, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		if(domain != null) {
			cookie.setDomain(domain);//共享
		}
		cookie.setPath(path);//权限
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(response, name, value, null, "/", maxAge);
	}
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, null, "/", 3600);
	}
	public static void setCookie(HttpServletResponse response, String name) {
		setCookie(response, name, "", null, "/", 3600);
	}

	/**获取
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					value = cookie.getValue();
				}
			}
		}
		return value;
	}

	/**
	 * 删除cookie
	 * @param response
	 * @param name
	 * @return
	 */
	public static void removeCookie(HttpServletResponse response, String name, String domain, String path) {
		setCookie(response, name, "", domain, path, 0);
	}

}