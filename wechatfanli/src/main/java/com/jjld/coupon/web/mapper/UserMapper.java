package com.jjld.coupon.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jjld.coupon.web.entity.User;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

	User login(@Param("loginname") String loginname, @Param("password") String password);

	User findUserById(@Param("id") Integer id);

	void update(User user);

	void updatePwd(User user);

}