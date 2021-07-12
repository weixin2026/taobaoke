package com.jjld.coupon.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaoxx
 * @Time 2019年6月26日上午11:01:21
 */
@Getter
@Setter
public class GoodsDTO implements Serializable {

    private static final long serialVersionUID = -3710225972531024782L;

    private Integer minId;
    /**
     * 商品平台1淘宝2京东3拼多多
     */
    private Integer platformId;
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 商品标题
     */
    private String itemTitle;
    /**
     * 商品链接
     */
    private String itemUrl;
    /**
     * 商品短标题
     */
    private String itemShortTitle;
    /**
     * 商品描述
     */
    private String itemContent;
    /**
     * 商品原价
     */
    private BigDecimal itemPrice;
    /**
     * 券后价
     */
    private BigDecimal itemEndPrice;
    /**
     * 商品主图
     */
    private String itemPictUrl;
    /**
     * 商品销量
     */
    private Integer itemSale;
    /**
     * 优惠券链接
     */
    private String couponUrl;
    /**
     * 优惠券价格
     */
    private Integer couponMoney;
    /**
     * 优惠券总量
     */
    private Integer couponCount;
    /**
     * 优惠券剩余量
     */
    private Integer couponSurplus;
    /**
     * 优惠券领取量
     */
    private Integer couponReceive;
    /**
     * 佣金比例
     */
    private String commission;
    /**
     * 优惠券id
     */
    private String activityId;
    /**
     * 返利金额
     */
    private BigDecimal tkMoney;

}
