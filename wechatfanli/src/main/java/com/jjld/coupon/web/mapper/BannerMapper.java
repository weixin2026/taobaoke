package com.jjld.coupon.web.mapper;

import com.jjld.coupon.web.entity.Banner;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface BannerMapper extends Mapper<Banner>, MySqlMapper<Banner> {
}