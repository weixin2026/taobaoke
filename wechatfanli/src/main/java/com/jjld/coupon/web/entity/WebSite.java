package com.jjld.coupon.web.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class WebSite implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String webname;

	private String domainname;

	private String logo;

	private String qrcode;// 联系商家的微信二维码

	private String aboutus;// 关于我们

	private String copyright;// 版权最下面的版权申明
  
	private String title;

	private String description;

	private String keywords;
 
	// 首页mate验证标签
	private String metavalidate;
	
	private String baidupushurl;//百度站长自动推送URL地址,具体请登陆百度站长选择对应站点
  
}
