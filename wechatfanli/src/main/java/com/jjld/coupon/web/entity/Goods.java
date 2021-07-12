package com.jjld.coupon.web.entity;

import com.jjld.coupon.framework.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品详情，直接从好单库抓取的数据
 * <p>
 * https://www.haodanku.com/api/detail/show/1.html
 *
 * @author SongFei
 * @date 2019/12/20 14:54
 */
@Table(name = "tbl_goods")
@Getter
@Setter
public class Goods extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 宝贝ID
     */
    private Long itemid;

    /**
     * 宝贝标题
     */
    private String itemtitle;

    /**
     * 宝贝短标题
     */
    private String itemshorttitle;

    /**
     * 宝贝推荐语
     */
    private String itemdesc;

    /**
     * 在售价
     */
    private BigDecimal itemprice;

    /**
     * 宝贝月销量
     */
    private Long itemsale;

    /**
     * 宝贝近2小时跑单
     */
    private Long itemsale2;

    /**
     * 当天销量
     */
    private Long todaysale;

    /**
     * 宝贝主图原始图像
     */
    private String itempic;

    /**
     * 推广长图（带http://img.haodanku.com/进行访问）
     */
    @Column(name = "itempic_copy")
    private String itempicCopy;

    /**
     * 轮播主图，用英文逗号分隔开来
     */
    @Column(name = "taobao_image")
    private String taobaoImage;

    /**
     * 商品类目：1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物
     */
    private Integer fqcat;

    /**
     * 宝贝券后价
     */
    private BigDecimal itemendprice;

    /**
     * 店铺类型：天猫店（B）淘宝店（C）
     */
    private String shoptype;

    /**
     * 优惠券链接
     */
    private String couponurl;

    /**
     * 优惠券金额
     */
    private BigDecimal couponmoney;

    /**
     * 是否为品牌产品（1是）
     */
    @Column(name = "is_brand")
    private Integer isBrand;

    /**
     * 是否为直播（1是）
     */
    @Column(name = "is_live")
    private Integer isLive;

    /**
     * 推广导购文案
     */
    @Column(name = "guide_article")
    private String guideArticle;

    /**
     * 商品视频ID（id大于0的为有视频单，视频拼接地址http://cloud.video.taobao.com/play/u/1/p/1/e/6/t/1/+videoid+.mp4）
     */
    private Long videoid;

    /**
     * 活动类型：普通活动/聚划算/淘抢购
     */
    @Column(name = "activity_type")
    private String activityType;

    /**
     * 营销计划链接
     */
    private String planlink;

    /**
     * 店主的userid
     */
    private Long userid;

    /**
     * 店铺掌柜名
     */
    private String sellernick;

    /**
     * 店铺名
     */
    private String shopname;

    /**
     * 佣金计划：/隐藏/营销
     */
    private String tktype;

    /**
     * 佣金比例
     */
    private BigDecimal tkrates;

    /**
     * 是否村淘（1是）
     */
    private Integer cuntao;

    /**
     * 预计可得（宝贝价格 * 佣金比例 / 100）
     */
    private BigDecimal tkmoney;

    /**
     * 当天优惠券领取量
     */
    private Long couponreceive2;

    /**
     * 优惠券剩余量
     */
    private Long couponsurplus;

    /**
     * 优惠券总数量
     */
    private Long couponnum;

    /**
     * 优惠券使用条件
     */
    private String couponexplain;

    /**
     * 优惠券开始时间
     */
    private Long couponstarttime;

    /**
     * 优惠券结束时间
     */
    private Long couponendtime;

    /**
     * 活动开始时间
     */
    @Column(name = "start_time")
    private Long startTime;

    /**
     * 活动结束时间
     */
    @Column(name = "end_time")
    private Long endTime;

    /**
     * 发布时间
     */
    private Long starttime;

    /**
     * 举报处理条件：0未举报、1为待处理、2为忽略、3为下架
     */
    @Column(name = "report_status")
    private Integer reportStatus;

    /**
     * 好单指数
     */
    @Column(name = "general_index")
    private Long generalIndex;

    /**
     * 放单人名号
     */
    @Column(name = "seller_name")
    private String sellerName;

    /**
     * 折扣力度
     */
    private BigDecimal discount;

    /**
     * 双十一定金
     */
    private BigDecimal deposit;

    /**
     * 双十一定金抵扣金额
     */
    @Column(name = "deposit_deduct")
    private BigDecimal depositDeduct;

}