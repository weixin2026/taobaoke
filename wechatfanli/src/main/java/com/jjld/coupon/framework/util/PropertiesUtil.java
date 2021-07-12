package com.jjld.coupon.framework.util;

import com.jjld.coupon.web.service.ConfigService;

public class PropertiesUtil {
	static ConfigService config = ProxyUtil.getBean("configService", ConfigService.class);
 
	public static String getStrValue(String name){
		return config.getStrValue(name);
	}

}
