package com.jjld.coupon.framework.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class Tools {

    // 判断是否手机访问
    public static boolean ismobile(HttpServletRequest request) {
        Boolean ismobile = (Boolean) request.getSession().getAttribute("ismobile");
	    return ismobile != null ? ismobile : Boolean.valueOf(ismobilefilter(request));
    }

    // 拦截器判断是否手机访问
    public static boolean ismobilefilter(HttpServletRequest request) {
        boolean ismobile = false;
        String userAgent = request.getHeader("user-agent");
        if (StringUtils.isNotEmpty(userAgent)) {
            if (userAgent.contains("Android")) {
                // 安卓
                ismobile = true;
            } else if (userAgent.contains("iPhone") || userAgent.contains("iPad")) {
                ismobile = true;
                // 苹果
            } else {
                ismobile = false;
                // 电脑
            }
        }

        return ismobile;
    }

    public static String getViewPath(HttpServletRequest request, String viewPath) {
        if (Tools.ismobile(request)) {
            return  "m/" + viewPath;
        }
        return "pc/" + viewPath;
    }

}
