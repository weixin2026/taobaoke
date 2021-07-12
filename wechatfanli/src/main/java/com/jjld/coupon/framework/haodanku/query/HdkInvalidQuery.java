package com.jjld.coupon.framework.haodanku.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 好单库失效商品列表API查询参数封装，参数与好单库保持一致，就不强行改成驼峰了，省事儿
 *
 * @author SongFei
 * @date 2019/12/24 15:28
 */
@Getter
@Setter
public class HdkInvalidQuery {

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

}
