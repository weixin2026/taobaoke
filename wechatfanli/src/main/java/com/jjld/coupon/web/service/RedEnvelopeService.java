package com.jjld.coupon.web.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.common.ServiceException;
import com.jjld.coupon.web.entity.RedEnvelope;
import com.jjld.coupon.web.entity.SaveMoney;
import com.jjld.coupon.web.mapper.RedEnvelopeMapper;
import com.jjld.coupon.web.query.RedEnvelopeQuery;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional // 支持事务
public class RedEnvelopeService {

	@Autowired
	private RedEnvelopeMapper redEnvelopeDao;

	public PageInfo<RedEnvelope> pageList(RedEnvelopeQuery query) {
		PageHelper.startPage(query.getPage(), query.getRows());
        
		Example example = new Example(RedEnvelope.class);
		Example.Criteria criteria = example.createCriteria();
		if (query.getType() != null) {
			criteria.andEqualTo("type", query.getType());
		}
		if (StringUtils.isNotBlank(query.getName())) {
			criteria.andLike("name", "%" + query.getName() + "%");
		}
		example.orderBy("id").desc();
		return new PageInfo<>(redEnvelopeDao.selectByExample(example));
		 
	}

	public int deleteByIds(String ids) {
		if (StringUtils.isBlank(ids)) {
			throw new ServiceException("invalid param");
		}
		String[] idArray = StringUtils.split(ids, ",");
		Set<String> userIds = Arrays.stream(idArray).filter(StringUtils::isNotBlank).collect(Collectors.toSet());
		Example example = new Example(SaveMoney.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andIn("id", userIds);

		return redEnvelopeDao.deleteByExample(example);
	}

 
	public RedEnvelope findRedEnvelopeByid(Integer id) {
		RedEnvelope user = redEnvelopeDao.findRedEnvelopeByid(id);
		return user;
	}

	public ResultInfo insert(RedEnvelope info) {
		ResultInfo res = new ResultInfo();
		try {
			info.setCreateTime(new Date());
			redEnvelopeDao.insert(info);
		} catch (Exception e) {
			return ResultInfo.fail("添加失败");
		}
		return res;
	}

	public ResultInfo update(RedEnvelope info) {
		ResultInfo res = new ResultInfo();
		try {
			info.setCreateTime(new Date());
			redEnvelopeDao.update(info);
		} catch (Exception e) {
			return ResultInfo.fail("修改失败");
		}
		return res;
	}

	public void delete(Integer id) {
		RedEnvelope info = new RedEnvelope();
		info.setId(id);
		redEnvelopeDao.delete(info);
	}

}
