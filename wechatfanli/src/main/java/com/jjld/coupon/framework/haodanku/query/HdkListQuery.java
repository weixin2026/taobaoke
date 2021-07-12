package com.jjld.coupon.framework.haodanku.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 好单库商品列表api查询参数封装，参数与好单库保持一致，就不强行改成驼峰了，省事儿
 *
 * @author SongFei
 * @date 2019/12/24 15:28
 */
@Getter
@Setter
public class HdkListQuery {

    /**
     * 放单后台获取的Apikey值
     */
    private String apikey;

    /**
     * 默认是全部商品1（1实时跑单商品，2爆单榜商品，3全部商品，4纯视频单，5聚淘专区）
     */
    private Integer nav;

    /**
     * 商品类目：
     * 0全部，1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物（支持多类目筛选，如1,2获取类目为女装、男装的商品，逗号仅限英文逗号）
     */
    private Integer cid;

    /**
     * 每页返回条数（请在1,2,10,20,50,100,120,200,500,1000中选择一个数值返回）
     */
    private Integer back;

    /**
     * 分页，用于实现类似分页抓取效果，来源于上次获取后的数据的min_id值，默认开始请求值为1（该方案比单纯123分页的优势在于：数据更新的情况下保证不会重复也无需关注和计算页数）
     */
    private Long min_id;

    /**
     * 0.综合（最新），1.券后价(低到高)，2.券后价（高到低），3.券面额（高到低），4.月销量（高到低），5.佣金比例（高到低），6.券面额（低到高），7.月销量（低到高），8.佣金比例（低到高），9.全天销量（高到低），10全天销量（低到高），11.近2小时销量（高到低），12.近2小时销量（低到高），13.优惠券领取量（高到低）
     * 注意：该排序仅对nav=3，4，5有效，1，2无效
     */
    private Integer sort;

    /**
     * 券后价筛选，筛选大于等于所设置的券后价的商品
     */
    private Integer price_min;

    /**
     * 券后价筛选，筛选小于等于所设置的券后价的商品
     */
    private Integer price_max;

    /**
     * 销量筛选，筛选大于等于所设置的销量的商品
     */
    private Integer sale_min;

    /**
     * 销量筛选，筛选小于等于所设置的销量的商品
     */
    private Integer sale_max;

    /**
     * 券金额筛选，筛选大于等于所设置的券金额的商品
     */
    private Integer coupon_min;

    /**
     * 券金额筛选，筛选小于等于所设置的券金额的商品
     */
    private Integer coupon_max;

    /**
     * 佣金比例筛选，筛选大于等于所设置的佣金比例的商品
     */
    private Integer tkrates_min;

    /**
     * 佣金比例筛选，筛选小于所设置的佣金比例的商品
     */
    private Integer tkrates_max;

    /**
     * 佣金筛选，筛选大于等于所设置的佣金的商品
     */
    private Integer tkmoney_min;

    /**
     * 是否只获取营销返利商品，1是，0否
     */
    private Integer item_type;

}
