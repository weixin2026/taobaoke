package com.jjld.coupon.web.service;

import com.github.pagehelper.PageHelper;
import com.jjld.coupon.web.entity.Banner;
import com.jjld.coupon.web.mapper.BannerMapper;
import com.jjld.coupon.web.query.BannerQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author SongFei
 * @date 2019/12/20 15:08
 */
@Service
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    private Example buildExample(BannerQuery query) {
        Example example = new Example(Banner.class);
        Example.Criteria criteria = example.createCriteria();
        if (query.getStatus() != null) {
            criteria.andEqualTo("status", query.getStatus());
        }
        return example;
    }

    public List<Banner> pageList(BannerQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return bannerMapper.selectByExample(buildExample(query));
    }

    public Integer count(BannerQuery query) {
        return bannerMapper.selectCountByExample(buildExample(query));
    }

    public List<Banner> list(BannerQuery query) {
        return bannerMapper.selectByExample(buildExample(query));
    }

}
