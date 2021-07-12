package com.jjld.coupon.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_savemoney")
@Getter
@Setter
public class SaveMoney implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	private Integer status;//0有效  1无效
	private String name;
	private String banner;
	private String link;
	@Column(name = "create_time")
	private Date createTime;
}
