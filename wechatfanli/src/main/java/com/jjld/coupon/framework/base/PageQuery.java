package com.jjld.coupon.framework.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页查询参数模型
 *
 * @author SongFei
 * @date 2019/12/11 18:44
 */
@Getter
@Setter
public class PageQuery {

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 条数
     */
    private Integer pageSize = 10;

    /**
     * 排序字段
     */
    private String sidx;

    /**
     * 排序（asc、desc）
     */
    private String sort;

}
