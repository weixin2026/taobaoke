package com.jjld.coupon.web.entity;

import com.jjld.coupon.framework.base.BaseEntity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_banner")
@Getter
@Setter
public class Banner extends BaseEntity {
 
	private static final long serialVersionUID = 1L;

	/**
     * 标题
     */
    private String title;

    /**
     * URL地址
     */
    private String url;

    /**
     * 顺序
     */
    private Integer sequ;

    /**
     * 图片
     */
    private String img;

    /**
     * 是否有效：0、无效；1、有效；
     */
    private Integer status;

}