package com.jjld.coupon.web.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SystemSettings implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String apikey;//好单库商品API的key，若站长未没配置可从公共key里面取
	
	private String authkey;//请求转链、优惠券接口需携带key请求，不然以后没法控制
	
	private String taoauthid;//淘宝授权id,中心系统配置过
	
	private String pid;//推广位pid,中心系统配置过
 
}
