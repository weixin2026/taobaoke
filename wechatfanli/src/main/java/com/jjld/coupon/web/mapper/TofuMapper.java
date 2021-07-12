package com.jjld.coupon.web.mapper;

import com.jjld.coupon.web.entity.Tofu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface TofuMapper extends Mapper<Tofu>, MySqlMapper<Tofu> {
}