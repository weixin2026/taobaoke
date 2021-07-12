package com.jjld.coupon.web.query;

import com.jjld.coupon.framework.base.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SongFei
 * @date 2019/12/30 15:14
 */
@Getter
@Setter
public class GoodsQuery extends PageQuery {

    /**
     * 宝贝标题
     */
    private String itemtitle;

    /**
     * 商品类目：1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物
     */
    private Integer fqcat;

}
