package com.jjld.coupon.web.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jjld.coupon.framework.common.Constants;
import com.jjld.coupon.framework.enums.YesOrNoEnum;
import com.jjld.coupon.web.entity.Goods;
import com.jjld.coupon.web.mapper.GoodsMapper;
import com.jjld.coupon.web.query.GoodsQuery;

import tk.mybatis.mapper.entity.Example;

/**
 * @author SongFei
 * @date 2019/12/20 15:08
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    private Example buildExample(GoodsQuery query) {
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", YesOrNoEnum.NO.getValue());
        if (!StringUtils.isBlank(query.getItemtitle())) {
            criteria.andLike("itemtitle", "%" + query.getItemtitle() + "%");
        }
        if (query.getFqcat() != null) {
            criteria.andEqualTo("fqcat", query.getFqcat());
        }
        if (!StringUtils.isBlank(query.getSidx())) {
            if (StringUtils.equals(Constants.DESC, query.getSort())) {
                example.orderBy(query.getSidx()).desc();
            } else {
                example.orderBy(query.getSidx()).asc();
            }
        } else {
            example.orderBy("id").desc();
        }
        return example;
    }

    public void insertGoods(Goods goods) {
        goodsMapper.insert(goods);
    }

    public Integer count(GoodsQuery query) {
        Example example = buildExample(query);
        return goodsMapper.selectCountByExample(example);
    }

    public Integer list(GoodsQuery query) {
        Example example = buildExample(query);
        return goodsMapper.selectCountByExample(example);
    }

    public List<Goods> pageList(GoodsQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return goodsMapper.selectByExample(buildExample(query));
    }

    public List<Goods> pageList(Integer pageNum, Integer pageSize) {
        Example example = new Example(Goods.class);
        RowBounds rowBounds = new RowBounds(pageSize * (pageNum - 1), pageSize);
        return goodsMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public Goods findByItemid(Long itemid) {
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemid", itemid);
        return goodsMapper.selectOneByExample(example);
    }
    
    public List<Goods> sameProductsHot(Integer fqcat, Long goodsId){
    	Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fqcat", fqcat);
        criteria.andGreaterThan("itemid", goodsId);
        RowBounds rowBounds = new RowBounds(0, 6);
        example.orderBy("itemid").desc();
    	return goodsMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    
    public List<Goods> guessYouLike(Integer fqcat, Long goodsId){
    	Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fqcat", fqcat);
        criteria.andLessThan("itemid", goodsId);
        RowBounds rowBounds = new RowBounds(0, 9);
        example.orderBy("itemid").desc();
    	return goodsMapper.selectByExampleAndRowBounds(example,rowBounds);
    	
    }


}
