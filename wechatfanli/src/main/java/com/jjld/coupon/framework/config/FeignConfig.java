package com.jjld.coupon.framework.config;
//package com.jjld.coupon.config;
//
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import feign.Logger;
//import feign.codec.Decoder;
//import org.springframework.beans.factory.ObjectFactory;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
//import org.springframework.cloud.openfeign.support.SpringDecoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 自定义Feign配置
// */
//@Configuration
//public class FeignConfig {
//
//    /**
//     * 返回信息解码converter
//     *
//     * @return Decoder
//     */
//    @Bean
//    public Decoder customDecoder() {
//        return new ResponseEntityDecoder(new SpringDecoder(fastJsonHttpMessageConverter()));
//    }
//
//    private ObjectFactory<HttpMessageConverters> fastJsonHttpMessageConverter() {
//        return () -> new HttpMessageConverters(new FastJsonHttpMessageConverter());
//    }
//
//    @Bean
//    Logger.Level feignLoggerLevel(){
//        return Logger.Level.FULL;
//    }
//
//}
