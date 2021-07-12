package com.jjld.coupon.web.mapper;

import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.Tag;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface TagMapper extends Mapper<Tag>, MySqlMapper<Tag> {
}