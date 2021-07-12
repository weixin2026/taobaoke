package com.jjld.coupon.framework.base;

import com.jjld.coupon.framework.util.StringUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Felix on 2018/10/25.
 */
@Getter
@Setter
public class BaseQuery {

    private Integer page;

    private Integer rows;

    private String sord;

    private String sidx;

    private Integer getOffset() {
        return rows * (page - 1);
    }

    public String getSidx() {
        if (sidx == null) {
            return null;
        }
        return StringUtil.camelToUnderline(sidx);
    }

}
