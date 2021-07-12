package com.jjld.coupon.framework.base;

import javax.servlet.http.HttpServletRequest;

import com.jjld.coupon.framework.common.Constants;
import com.jjld.coupon.framework.util.SessionUtil;

/**
 * 基础controller，封装一些公共方法
 *
 * @author SongFei
 * @date 2020/2/15 19:24
 */
public class BaseController<T> {

    /**
     * 是否重复提交表单
     *
     * @param request 请求
     * @return true/false
     */
    protected boolean isRepeatSubmit(HttpServletRequest request) {
        String clientToken = request.getParameter(Constants.TOKEN);
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if (clientToken == null) {
            return true;
        }
        //取出存储在Session中的token
        String serverToken = SessionUtil.getToken(request);
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if (serverToken == null) {
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        return !clientToken.equals(serverToken);
    }

}
