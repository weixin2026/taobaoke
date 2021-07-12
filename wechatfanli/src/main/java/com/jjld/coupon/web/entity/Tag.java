package com.jjld.coupon.web.entity;

import javax.persistence.Table;

import com.jjld.coupon.framework.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_tags")
@Getter
@Setter
public class Tag extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 类目id
	 */
	private String cateid;

	/**
	 * tag标签名
	 */
	private String name;

	/**
	 * 链接地址
	 */
	private String link;

	/**
	 * 顺序
	 */
	private Integer seq;

}