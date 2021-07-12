package com.jjld.coupon.web.entity;

import com.jjld.coupon.framework.base.BaseEntity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_tofu")
@Getter
@Setter
public class Tofu extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
     * 位置
     */
    private Integer position;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片
     */
    private String img;

    /**
     * URL地址
     */
    private String url;

    /**
     * 顺序
     */
    private Integer sequ;

    /**
     * 是否有效：0、无效；1、有效；
     */
    private Integer status;

}