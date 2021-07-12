package com.jjld.coupon.framework.haodanku.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 好单库商品更新API查询参数封装，参数与好单库保持一致，就不强行改成驼峰了，省事儿
 *
 * @author SongFei
 * @date 2019/12/24 15:28
 */
@Getter
@Setter
public class HdkUpdateQuery {

    /**
     * 放单后台获取的Apikey值
     */
    private String apikey;

    /**
     * 0.综合（最新），1.券后价(低到高)，2.券后价（高到低），3.券面额（高到低），4.月销量（高到低），5.佣金比例（高到低），6.券面额（低到高），7.月销量（低到高），8.佣金比例（低到高），9.全天销量（高到低），10全天销量（低到高），11.近2小时销量（高到低），12.近2小时销量（低到高），13.优惠券领取量（高到低）
     * 注意：该排序仅对nav=3，4，5有效，1，2无效
     */
    private Integer sort;

    /**
     * 每页返回条数（请在1,2,10,20,50,100,120,200,500,1000中选择一个数值返回）
     */
    private Integer back;

    /**
     * 分页，用于实现类似分页抓取效果，来源于上次获取后的数据的min_id值，默认开始请求值为1（该方案比单纯123分页的优势在于：数据更新的情况下保证不会重复也无需关注和计算页数）
     */
    private Long min_id;

}
