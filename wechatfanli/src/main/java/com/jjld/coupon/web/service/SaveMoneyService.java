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
import com.jjld.coupon.web.entity.SaveMoney;
import com.jjld.coupon.web.mapper.SaveMoneyMapper;
import com.jjld.coupon.web.query.SaveMoneyQuery;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional // 支持事务
public class SaveMoneyService {

	@Autowired
	private SaveMoneyMapper saveMoneyDao;

	public PageInfo<SaveMoney> pageList(SaveMoneyQuery query) {
		PageHelper.startPage(query.getPage(), query.getRows());
        
		Example example = new Example(SaveMoney.class);
		Example.Criteria criteria = example.createCriteria();
		if (query.getStatus() != null) {
			criteria.andEqualTo("status", query.getStatus());
		}
		if (StringUtils.isNotBlank(query.getName())) {
			criteria.andLike("name", "%" + query.getName() + "%");
		}
		example.orderBy("id").desc();
		return new PageInfo<>(saveMoneyDao.selectByExample(example));
		 
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

		return saveMoneyDao.deleteByExample(example);
	}

 
	public SaveMoney getSaveMoneyByid(Integer id) {
		SaveMoney user = saveMoneyDao.findSaveMoneyByid(id);
		return user;
	}

	public ResultInfo insert(SaveMoney info) {
		ResultInfo res = new ResultInfo();
		try {
			info.setCreateTime(new Date());
			saveMoneyDao.insert(info);
		} catch (Exception e) {
			return ResultInfo.fail("添加失败");
		}
		return res;
	}

	public ResultInfo update(SaveMoney info) {
		ResultInfo res = new ResultInfo();
		try {
			info.setCreateTime(new Date());
			saveMoneyDao.update(info);
		} catch (Exception e) {
			return ResultInfo.fail("修改失败");
		}
		return res;
	}

	public void delete(Integer id) {
		SaveMoney info = new SaveMoney();
		info.setId(id);
		saveMoneyDao.delete(info);
	}

}
