package com.jjld.coupon.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
@Service
public class ConfigService {
	@Autowired
    private Environment env;
	  
	public String getStrValue(String name){
		return env.getProperty(name);
	}
 
}
