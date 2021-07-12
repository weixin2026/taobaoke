package com.jjld.coupon.framework.haodanku.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 好单库商品定时拉取API查询参数封装，参数与好单库保持一致，就不强行改成驼峰了，省事儿
 *
 * @author SongFei
 * @date 2019/12/24 15:28
 */
@Getter
@Setter
public class HdkTimingQuery {

    /**
     * 放单后台获取的Apikey值
     */
    private String apikey;

    /**
     * 小时点数，如0点是0、13点是13（最小值是0，最大值是23）
     */
    private Integer start;

    /**
     * 小时点数，如0点是0、13点是13（最小值是0，最大值是23）
     */
    private Integer end;

    /**
     * 分页，用于实现类似分页抓取效果，来源于上次获取后的数据的min_id值，默认开始请求值为1（该方案比单纯123分页的优势在于：数据更新的情况下保证不会重复也无需关注和计算页数）
     */
    private Long min_id;

    /**
     * 每页返回条数（请在1,2,10,20,50,100,120,200,500,1000中选择一个数值返回）
     */
    private Integer back;

    /**
     * 是否只获取营销返利商品，1是，0否
     */
    private Integer item_type;

}
