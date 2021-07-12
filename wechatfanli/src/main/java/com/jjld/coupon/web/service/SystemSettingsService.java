package com.jjld.coupon.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjld.coupon.web.entity.SystemSettings;
import com.jjld.coupon.web.mapper.SystemSettingsMapper;

@Service
public class SystemSettingsService{

	@Autowired
	private SystemSettingsMapper systemSettingsDao;
 
	@Autowired
	private CommonService commonService;
	 
	public SystemSettings getSystemSettings() {
		SystemSettings sys = systemSettingsDao.getSystemSettings();
		if(null == sys){
			sys = new SystemSettings();
		}
		return sys;
	}
	
	
	public String update(SystemSettings info){
		String res ="success";
		try {
			systemSettingsDao.update(info);
			//刷新系统设置
			commonService.cacheSysData();
		} catch (Exception e) {
			res ="fail";
			e.printStackTrace();
		}
		return res;
	}
	 
	public String insert(SystemSettings info){
		String res ="success";
		try {
			systemSettingsDao.insert(info);
			//刷新系统设置
			commonService.cacheSysData();
		} catch (Exception e) {
			res ="fail";
			e.printStackTrace();
		}
		return res;
	}

}
