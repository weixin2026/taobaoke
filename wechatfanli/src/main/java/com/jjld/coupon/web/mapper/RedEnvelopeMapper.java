package com.jjld.coupon.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.RedEnvelope;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface RedEnvelopeMapper  extends Mapper<RedEnvelope>, MySqlMapper<RedEnvelope>{
	  
	RedEnvelope findRedEnvelopeByid(@Param("id")Integer id);
	  
	int insert(RedEnvelope info);
	
	void update(RedEnvelope info);
	
	int delete(RedEnvelope info);
  
}
