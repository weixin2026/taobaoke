package com.jjld.coupon.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjld.coupon.web.entity.WebSite;
import com.jjld.coupon.web.mapper.WebSiteMapper;

@Service
public class WebSiteService{

	@Autowired
	private WebSiteMapper WebSiteMapper;
 
	@Autowired
	private CommonService commonService;
	 
	public WebSite getSystemSettings() {
		WebSite sys = WebSiteMapper.getWebSites();
		if(null == sys){
			sys = new WebSite();
		}
		return sys;
	}
	
	
	public String update(WebSite info){
		String res ="success";
		try {
			info.setCopyright(info.getCopyright().replaceAll("\"", "'"));
			WebSiteMapper.update(info);
			//刷新系统设置
			commonService.cacheSysData();
		} catch (Exception e) {
			res ="fail";
			e.printStackTrace();
		}
		return res;
	}
	 
	public String insert(WebSite info){
		String res ="success";
		try {
			info.setCopyright(info.getCopyright().replaceAll("\"", "'"));
			WebSiteMapper.insert(info);
			//刷新系统设置
			commonService.cacheSysData();
		} catch (Exception e) {
			res ="fail";
			e.printStackTrace();
		}
		return res;
	}

}
