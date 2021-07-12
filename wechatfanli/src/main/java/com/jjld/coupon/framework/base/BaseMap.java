package com.jjld.coupon.framework.base;

import java.util.HashMap;
import java.util.Map;

import com.jjld.coupon.framework.util.PublicStatic;

public class BaseMap {
	public static Map<String, Object> getBaseData() {
		Map<String,Object> map = new HashMap<>();
        map.put("web", PublicStatic.web);
        return map;
	}
}
