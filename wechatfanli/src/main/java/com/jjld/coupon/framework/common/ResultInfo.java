package com.jjld.coupon.framework.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author SongFei
 * @date 2020/1/7 15:03
 */
@Getter
@Setter
@Accessors(chain = true)
public class ResultInfo {

    /**
     * 业务码（0、成功）
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object data;

    public static ResultInfo success() {
        ResultInfo info = new ResultInfo();
        info.setCode(0);
        info.setMsg(Constants.SUCCESS);
        return info;
    }

    public static ResultInfo success(Object data) {
        ResultInfo info = new ResultInfo();
        info.setCode(0);
        info.setMsg(Constants.SUCCESS);
        info.setData(data);
        return info;
    }

    public static ResultInfo fail() {
        ResultInfo info = new ResultInfo();
        info.setCode(-1);
        info.setMsg(Constants.FAIL);
        return info;
    }
    
    public static ResultInfo fail(String msg) {
        ResultInfo result = fail();
        result.setMsg(msg);
        return result;
    }

}
