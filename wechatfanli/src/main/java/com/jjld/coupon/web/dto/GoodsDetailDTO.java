package com.jjld.coupon.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsDetailDTO implements Serializable {

    private static final long serialVersionUID = 6032697540783322433L;

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
     * 商品小图列表
     */
    private List<String> itemSmallImages;
    /**
     * 商品类型 用字母表示 C淘宝B天猫J京东P拼多多
     */
    private String itemType;
    /**
     * 商品销量 宝贝月销量
     */
    private Integer itemSale;
    /**
     * 是否包邮
     */
    private Boolean freeShipment;

	//  /**商品详情图*/
	//	private List<String> itemDetail;

    /**
     * 0=普通产品1=京东配送
     */
    private Integer jdType;

    /**
     * 优惠券链接
     */
    private String couponUrl;
    /**
     * 优惠券价格
     */
    private Integer couponMoney;
    /**
     * 优惠券开始时间
     */
    private String couponStartTime;
    /**
     * 优惠券结束时间
     */
    private String couponEndTime;
    /**
     * 优惠券领取量百分比
     */
    private Integer couponReceiveCount;
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
     * 优惠券筛选-是否有优惠券。true表示该商品有优惠券，false表示没有
     */
    private Boolean hasCoupon;
    /**
     * 佣金比例
     */
    private String commission;
    /**
     * 优惠券id
     */
    private String activityId;

    /**
     * 店铺ID
     */
    private String shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺图片
     */
    private String shopPicUrl;
    /**
     * 店铺小标
     */
    private String shopTag;
    /**
     * 店铺Url
     */
    private String shopUrl;

    //  /**店铺评分信息*/
	//	private List<evaluatesDataBean> eval;

    /**
     * 返利金额
     */
    private BigDecimal tkMoney;
    /**
     * 分享赚
     */
    private BigDecimal shareTkMoney;

	//	@Getter
	//	@Setter
	//	private static class evaluatesDataBean implements Serializable {
	//
	//			private static final long serialVersionUID = -3312467585212545842L;
	//
	//			private String title;
	//            private String score;
	//            private String type;
	//            private String level;
	//            private String levelText;
	//            private String levelTextColor;
	//            private String levelBackgroundColor;
	//            private String tmallLevelTextColor;
	//            private String tmallLevelBackgroundColor;
	//	}

}
