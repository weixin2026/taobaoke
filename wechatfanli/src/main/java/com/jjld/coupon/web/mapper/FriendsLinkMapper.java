package com.jjld.coupon.web.mapper;

import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.FriendsLink;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface FriendsLinkMapper extends Mapper<FriendsLink>, MySqlMapper<FriendsLink> {
}