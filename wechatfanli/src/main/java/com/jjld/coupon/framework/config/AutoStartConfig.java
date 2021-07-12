package com.jjld.coupon.framework.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jjld.coupon.framework.util.ProxyUtil;
import com.jjld.coupon.web.service.CommonService;

@Order(value = 200000)
@Component
public class AutoStartConfig implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		CommonService commonService = (CommonService) ProxyUtil.getBean("commonService");
		// 缓存公共数据
		commonService.cacheSysData();
		commonService.cacheWebData();
	}

}
