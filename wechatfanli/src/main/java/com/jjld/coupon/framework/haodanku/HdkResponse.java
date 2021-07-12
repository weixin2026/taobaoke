package com.jjld.coupon.framework.haodanku;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 好单库api返回格式封装
 *
 * @author SongFei
 * @date 2019/12/24 14:40
 */
@Getter
@Setter
public class HdkResponse<T> {

    /**
     * 状态码（1成功，0失败或没有数据返回）
     */
    private Integer code;

    /**
     * 返回信息说明，SUCCESS代表成功获取，失败则有具体原因
     */
    private String msg;

    /**
     * 接口响应内容
     */
    private List<T> data;

    /**
     * 作为请求地址中获取下一页的参数值
     */
    private Long min_id;

}
