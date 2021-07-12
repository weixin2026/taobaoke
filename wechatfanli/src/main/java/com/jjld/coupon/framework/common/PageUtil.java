package com.jjld.coupon.framework.common;

import java.util.List;

/**
 * @author SongFei
 * @date 2019/11/18 23:45
 */
public class PageUtil {

    /**
     * 组装分页信息
     *
     * @param total    总条数
     * @param data     结果集
     * @param pageSize 每页条数
     * @return 分页合集
     */
    public static <T> PageInfo<T> wrap(Integer total, List<T> data, Integer pageSize) {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setData(data);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(total);
        pageInfo.setTotalPage(getTotalPage(total, pageSize));
        return pageInfo;
    }

    public static Integer getTotalPage(Integer total, Integer pageSize) {
        if (total == null || total <= 0) {
            return 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = Constants.DEFAULT_PAGE_SIZE;
        }
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

}
