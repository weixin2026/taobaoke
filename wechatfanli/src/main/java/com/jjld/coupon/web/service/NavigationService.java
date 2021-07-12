package com.jjld.coupon.web.service;

import com.github.pagehelper.PageHelper;
import com.jjld.coupon.web.entity.Navigation;
import com.jjld.coupon.web.mapper.NavigationMapper;
import com.jjld.coupon.web.query.NavigationQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author SongFei
 * @date 2019/12/20 15:08
 */
@Service
public class NavigationService {

    @Autowired
    private NavigationMapper navigationMapper;

    private Example buildExample(NavigationQuery query) {
        Example example = new Example(Navigation.class);
        Example.Criteria criteria = example.createCriteria();
        if (query.getStatus() != null) {
            criteria.andEqualTo("status", query.getStatus());
        }
        return example;
    }

    public List<Navigation> pageList(NavigationQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return navigationMapper.selectByExample(buildExample(query));
    }

    public Integer count(NavigationQuery query) {
        return navigationMapper.selectCountByExample(buildExample(query));
    }

    public List<Navigation> list(NavigationQuery query) {
        return navigationMapper.selectByExample(buildExample(query));
    }

}
