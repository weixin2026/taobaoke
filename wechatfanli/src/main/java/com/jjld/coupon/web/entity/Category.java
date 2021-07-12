package com.jjld.coupon.web.entity;

import com.jjld.coupon.framework.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_category")
@Getter
@Setter
public class Category extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 对应好单库的类目ID
     */
    private Integer fqcat;

    /**
     * 排名
     */
    private Integer rank;

    /**
     * 手机图标
     */
    private String micon;

    /**
     * PC图标
     */
    private String pcicon;

    /**
     * 样式
     */
    private String css;
    
    /**
     * 网页title
     */
    private String title;

    /**
     * 网页description
     */
	private String description;

	/**
     * 网页keywords
     */
	private String keywords;

    /**
     * 是否有效：0、无效；1、有效；
     */
    private Integer status;

}