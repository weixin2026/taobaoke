package com.jjld.coupon.web.service;

import com.github.pagehelper.PageHelper;
import com.jjld.coupon.web.entity.Tofu;
import com.jjld.coupon.web.mapper.TofuMapper;
import com.jjld.coupon.web.query.TofuQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author SongFei
 * @date 2019/12/20 15:08
 */
@Service
public class TofuService {

    @Autowired
    private TofuMapper tofuMapper;

    private Example buildExample(TofuQuery query) {
        Example example = new Example(Tofu.class);
        Example.Criteria criteria = example.createCriteria();
        if (query.getStatus() != null) {
            criteria.andEqualTo("status", query.getStatus());
        }
        return example;
    }

    public List<Tofu> pageList(TofuQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return tofuMapper.selectByExample(buildExample(query));
    }

    public Integer count(TofuQuery query) {
        return tofuMapper.selectCountByExample(buildExample(query));
    }

    public List<Tofu> list(TofuQuery query) {
        return tofuMapper.selectByExample(buildExample(query));
    }

}
