package com.jjld.coupon.web.service;

import java.util.Arrays;
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
import com.jjld.coupon.framework.util.MD5Util;
import com.jjld.coupon.web.entity.User;
import com.jjld.coupon.web.mapper.UserMapper;
import com.jjld.coupon.web.query.SysUserQuery;

import tk.mybatis.mapper.entity.Example;

/**
 * @author SongFei
 * @date 2019/12/20 15:08
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userDao;

	public User login(String loginname, String password) {
		String newpassword = MD5Util.getMD5(loginname + password);// F6FDFFE48C908DEB0F4C3BD36C032E72
		User user = userDao.login(loginname, newpassword);
		return user;
	}

	public PageInfo<User> pageList(SysUserQuery query) {
        PageHelper.startPage(query.getPage(), query.getRows());

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted", 0);
        if (StringUtils.isNotBlank(query.getUserName())) {
            criteria.andLike("account", "%" + query.getUserName() + "%");
        }
        if (StringUtils.isNotBlank(query.getNickName())) {
            criteria.andLike("nickname", "%" + query.getNickName() + "%");
        }
        example.orderBy("id").desc();

        return new PageInfo<>(userDao.selectByExample(example));
    }
	
	public User findUserById(Integer id) {
		User user = userDao.findUserById(id);
		return user;
	}

	@Transactional(rollbackFor = Exception.class)
	public int deleteById(Long id) {
		if (id == null || id <= 0) {
			throw new ServiceException("invalid param");
		}
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id", id);

		User sysUser = new User();
		sysUser.setDeleted(1);
		return userDao.updateByExampleSelective(sysUser, example);
	}

	public int deleteByIds(String ids) {
		if (StringUtils.isBlank(ids)) {
			throw new ServiceException("invalid param");
		}
		String[] idArray = StringUtils.split(ids, ",");
		Set<String> userIds = Arrays.stream(idArray).filter(StringUtils::isNotBlank).collect(Collectors.toSet());
		userIds.remove("1");//1是管理员，不能删
		
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andIn("id", userIds);

		User sysUser = new User();
		sysUser.setDeleted(1);
		return userDao.updateByExampleSelective(sysUser, example);
	}

	public ResultInfo updatePwd(User user) {
		try {
			String password = MD5Util.getMD5(user.getAccount() + user.getPassword());
			User usr = userDao.login(user.getAccount(), password);
			if (null == usr) {
				return ResultInfo.fail("原密码错误");
			} else {
				String pwd = MD5Util.getMD5(user.getAccount() + user.getNewPassWord());
				User u = new User(usr.getId(), user.getAccount(), pwd);
				userDao.updatePwd(u);
			}
		} catch (Exception e) {
			return ResultInfo.fail("修改失败");
		}
		return ResultInfo.success();
	}

	public ResultInfo update(User user) {
		try {
			userDao.update(user);
		} catch (Exception e) {
			return ResultInfo.fail("修改失败");
		}
		return ResultInfo.success();
	}

}
