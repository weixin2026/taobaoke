package com.jjld.coupon.web.entity;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.jjld.coupon.framework.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
 
@Table(name = "tbl_user")
@Getter
@Setter
public class User extends BaseEntity {
 
	private static final long serialVersionUID = 1L;
 
	/**
	 * 账号
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 电话号码
	 */
	private String phonenumber;
	 
	/**
	 * 生日
	 */
	private String birthday;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 座右铭
	 */
	private String motto;

	/**
	 * 登录时间（每次登录都更新）
	 */
	private Date login_time;
	
	public User() {}
	
	public User(Integer id,String account, String password) {
		this.id = id;
		this.account = account;
		this.password = password;
	}

 
	/////////////////////////////
	@Transient
	private String newPassWord;

}