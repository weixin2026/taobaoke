package com.jjld.coupon.framework.common;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GridPage<T> {

    private Integer page = 1;

    private Integer total;

    private Long records;

    private List<T> rows = new ArrayList<>();

    public GridPage(PageInfo<T> pageInfo) {
        setPage(pageInfo.getPageNum() == 0 ? 1 : pageInfo.getPageNum());
        setRecords(pageInfo.getTotal());
        setTotal(pageInfo.getPages());
        setRows(pageInfo.getList());
    }

}
