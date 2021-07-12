package com.jjld.coupon.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_redenvelope")
@Getter
@Setter
public class RedEnvelope implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	private Integer type;
	private String name;
	private String kl;
	private String content;
	@Column(name = "create_time")
	private Date createTime;
}
