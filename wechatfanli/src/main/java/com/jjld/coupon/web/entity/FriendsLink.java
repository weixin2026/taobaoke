package com.jjld.coupon.web.entity;

import java.io.Serializable;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Table(name = "tbl_friendslink")
@Getter
@Setter
public class FriendsLink implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String link;

	private Integer type;// 0 首页 1栏目页

	private Integer seq;

	public FriendsLink() {
		super();
	}
 
}
