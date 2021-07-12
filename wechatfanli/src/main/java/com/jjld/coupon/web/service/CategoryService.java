package com.jjld.coupon.web.service;

import com.github.pagehelper.PageHelper;
import com.jjld.coupon.web.entity.Category;
import com.jjld.coupon.web.mapper.CategoryMapper;
import com.jjld.coupon.web.query.CategoryQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author SongFei
 * @date 2019/12/20 15:08
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    private Example buildExample(CategoryQuery query) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        if (query.getStatus() != null) {
            criteria.andEqualTo("status", query.getStatus());
        }
        return example;
    }

    public List<Category> pageList(CategoryQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return categoryMapper.selectByExample(buildExample(query));
    }

    public Integer count(CategoryQuery query) {
        return categoryMapper.selectCountByExample(buildExample(query));
    }

    public List<Category> list(CategoryQuery query) {
        return categoryMapper.selectByExample(buildExample(query));
    }

    public Category findCategoryByid(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

}
