package com.jjld.coupon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjld.coupon.web.entity.FriendsLink;
import com.jjld.coupon.web.mapper.FriendsLinkMapper;

@Service
public class FriendsLinkService {

	@Autowired
	private FriendsLinkMapper friendsLinkMapper;

	public List<FriendsLink> list() {
		return friendsLinkMapper.selectAll();
	}

}
