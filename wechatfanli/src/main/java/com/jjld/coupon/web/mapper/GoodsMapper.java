package com.jjld.coupon.web.mapper;

import com.jjld.coupon.web.entity.Goods;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface GoodsMapper extends Mapper<Goods>, MySqlMapper<Goods> {
}