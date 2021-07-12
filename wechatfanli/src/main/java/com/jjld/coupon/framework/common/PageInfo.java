package com.jjld.coupon.framework.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author SongFei
 * @date 2019/11/18 23:40
 */
@Getter
@Setter
public class PageInfo<T> {

    private Integer totalPage;
    private Integer total;
    private Integer pageSize;
    private List<T> data;

}
