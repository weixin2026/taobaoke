package com.jjld.coupon.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.jjld.coupon.framework.common.Constants;
import com.jjld.coupon.web.entity.User;

/**
 * Session工具类
 * Created by SongFei on 2016/12/24.
 */
public class SessionUtil {

    /**
     * 获取session
     *
     * @param request 请求
     * @return HttpSession
     */
    public static HttpSession getSession(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        return request.getSession();
    }

    public static String getSessionId(HttpServletRequest request) {
        HttpSession session = getSession(request);
        return session == null ? null : session.getId();
    }

    /**
     * 将内容放入session中
     *
     * @param key   键
     * @param value 值
     */
    public static void set(HttpServletRequest request, String key, Object value) {
        if (null == getSession(request) || null == value) {
            return;
        }
        getSession(request).setAttribute(key, value);
    }

    /**
     * 获取session中的内容
     *
     * @param key 键
     * @return key对应的值
     */
    public static Object get(HttpServletRequest request, String key) {
        if (null == getSession(request) || StringUtils.isBlank(key)) {
            return null;
        }
        return getSession(request).getAttribute(key);
    }

    /**
     * 移除session中的内容
     *
     * @param key 键
     */
    public static void del(HttpServletRequest request, String key) {
        if (null == getSession(request) || StringUtils.isBlank(key)) {
            return;
        }
        getSession(request).removeAttribute(key);
    }

    /**
     * 放置token，用来防止form表单重复提交
     *
     * @param request 请求
     * @param token   token串
     */
    public static void setToken(HttpServletRequest request, String token) {
        set(request, Constants.TOKEN, token);
    }

    /**
     * 获取token
     *
     * @param request 请求
     * @return token
     */
    public static String getToken(HttpServletRequest request) {
        return (String) get(request, Constants.TOKEN);
    }

    /**
     * 删除token
     *
     * @param request 请求
     */
    public static void delToken(HttpServletRequest request) {
        del(request, Constants.TOKEN);
    }

    /**
     * 设置user，用户登录之后，暂时记录在session中
     *
     * @param request 请求
     * @param sysUser 用户
     */
    public static void setUser(HttpServletRequest request, User sysUser) {
        set(request, Constants.USER, sysUser);
    }

    /**
     * 获取当前登录user
     *
     * @param request 请求
     * @return 用户
     */
    public static User getUser(HttpServletRequest request) {
        return (User) get(request, Constants.USER);
    }

    /**
     * 删除session中记录的用户
     *
     * @param request 请求
     */
    public static void delUser(HttpServletRequest request) {
        del(request, Constants.USER);
    }

}
