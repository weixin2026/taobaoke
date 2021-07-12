package com.jjld.coupon.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjld.coupon.framework.util.PublicStatic;
import com.jjld.coupon.web.entity.SystemSettings;
import com.jjld.coupon.web.entity.WebSite;
import com.jjld.coupon.web.mapper.SystemSettingsMapper;
import com.jjld.coupon.web.mapper.WebSiteMapper;

@Service
@Transactional // 支持事务
public class CommonService {

	@Autowired
	private SystemSettingsMapper systemSettingsDao;
	
	@Autowired
	private WebSiteMapper webSiteMapper;

	public void cacheSysData() {
		SystemSettings sys = systemSettingsDao.getSystemSettings();
		if (null != sys) {
			PublicStatic.sys = sys;
		}
	}
	
	public void cacheWebData() {
		WebSite web = webSiteMapper.getWebSites();
		if (null != web) {
			PublicStatic.web = web;
		}
	}

}
