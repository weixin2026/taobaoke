package com.jjld.coupon.web.entity;

import com.jjld.coupon.framework.base.BaseEntity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_navigation")
@Getter
@Setter
public class Navigation extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    private String name;

    /**
     * URL地址
     */
    private String url;

    /**
     * 顺序
     */
    private Integer sequ;

    /**
     * 图标
     */
    private String icon;

    /**
     * 样式
     */
    private String css;

    /**
     * 是否有效：0、无效；1、有效；
     */
    private Integer status;

}