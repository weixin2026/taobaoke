package com.jjld.coupon.framework.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring获取bean的工具类，用于非spring托管的地方
 *
 * @author SongFei
 * @date 2016/12/25
 */
@Component
public class ProxyUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ProxyUtil.applicationContext = applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) throws BeansException {
		return applicationContext.getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
		if (StringUtils.isBlank(name)) {
			return getBean(clazz);
		}
		if (clazz == null) {
			return getBean(name);
		}
		return applicationContext.getBean(name, clazz);
	}

	public static <T> Map<String, T> getSubClass(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz);
	}

	public static String[] getSubClassName(Class<?> clazz) {
		return applicationContext.getBeanNamesForType(clazz);
	}

}
