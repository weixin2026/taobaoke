package com.jjld.coupon.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.SystemSettings;

@Mapper
@Repository
public interface SystemSettingsMapper {
	
	SystemSettings getSystemSettings();
	
	void update(SystemSettings info);
	
	void insert(SystemSettings info);
	
}
