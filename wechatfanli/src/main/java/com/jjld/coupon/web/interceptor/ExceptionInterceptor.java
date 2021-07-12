package com.jjld.coupon.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jjld.coupon.framework.util.SessionUtil;
import com.jjld.coupon.web.entity.User;

public class ExceptionInterceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// System.out.println("----afterCompletion在页面渲染之后被调用--好像没啥鸟用--");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2,
			ModelAndView modelAndView) throws Exception {
		// System.out.println("----postHandle在controller执行之后切页面渲染之前被调用----");
		if (modelAndView == null) {
			modelAndView = new ModelAndView();
		}
		if (response.getStatus() >= 500) {
			response.setStatus(500);
			modelAndView.setViewName("/admin/error");
		} else if (response.getStatus() == 404) {
			response.setStatus(404);
			modelAndView.setViewName("/admin/404");
		}

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// System.out.println("-----preHandle在controller执行之前被调用------");
		try {
			User user =	SessionUtil.getUser(request);
			if(null == user) {
				response.sendRedirect(request.getContextPath() + "/cms/login");
				return false;
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/cms/login");
			return false;
		}

		return true;
	}
}
