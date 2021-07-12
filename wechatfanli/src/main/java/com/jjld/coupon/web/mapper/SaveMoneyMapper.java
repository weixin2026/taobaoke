package com.jjld.coupon.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.SaveMoney;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface SaveMoneyMapper  extends Mapper<SaveMoney>, MySqlMapper<SaveMoney>{
	  
	SaveMoney findSaveMoneyByid(@Param("id")Integer id);
	  
	int insert(SaveMoney info);
	
	void update(SaveMoney info);
	
	int delete(SaveMoney info);
  
}
