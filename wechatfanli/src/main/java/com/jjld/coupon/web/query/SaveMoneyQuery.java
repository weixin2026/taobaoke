package com.jjld.coupon.web.query;

import com.jjld.coupon.framework.base.BaseQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveMoneyQuery extends BaseQuery {
	private Integer status;//0有效  1无效
	private String name;
}
