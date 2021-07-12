package com.jjld.coupon.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.WebSite;

@Mapper
@Repository
public interface WebSiteMapper {
	
	WebSite getWebSites();
	
	void update(WebSite info);
	
	void insert(WebSite info);
	
}
