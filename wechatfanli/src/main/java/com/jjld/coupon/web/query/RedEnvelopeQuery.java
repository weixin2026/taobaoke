package com.jjld.coupon.web.query;

import com.jjld.coupon.framework.base.BaseQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedEnvelopeQuery extends BaseQuery {
	private Integer type;
	private String name;
}
