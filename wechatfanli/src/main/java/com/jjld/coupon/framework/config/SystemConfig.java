package com.jjld.coupon.framework.config;

import com.jjld.coupon.framework.util.PropertiesUtil;
import com.jjld.coupon.web.interceptor.ExceptionInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by wolffy on 2019/12/16.
 */
@Configuration
public class SystemConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        //resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths("classpath:/templates/");
        configurer.setDefaultEncoding("UTF-8");
        //configurer.setFreemarkerVariables();
        return configurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/** 访问都映射到classpath:/ 目录下
        //也可配置/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/image/**").addResourceLocations(PropertiesUtil.getStrValue("local.filepath"));
        super.addResourceHandlers(registry);
    }
    
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("进入拦截器。。。。");
  
		registry.addInterceptor(new ExceptionInterceptor()).addPathPatterns("/cms/**")
                .excludePathPatterns("/cms/","/cms/login");
	    super.addInterceptors(registry);
	}

}
