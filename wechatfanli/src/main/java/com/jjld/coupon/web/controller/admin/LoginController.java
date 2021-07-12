package com.jjld.coupon.web.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.util.SessionUtil;
import com.jjld.coupon.web.dto.LoginDTO;
import com.jjld.coupon.web.entity.User;
import com.jjld.coupon.web.service.UserService;

@Controller
@RequestMapping("/cms")
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value = {"/","/login","/admin"})
	public ModelAndView login() {
		return new ModelAndView("/admin/login");
	}

	@PostMapping("/login")
	@ResponseBody
	public ResultInfo login(HttpServletRequest request, LoginDTO dto) {
		if (StringUtils.isBlank(dto.getUsername())) {
			return ResultInfo.fail("账号不能为空");
		}
		if (StringUtils.isBlank(dto.getPassword())) {
			return ResultInfo.fail("密码不能为空");
		}

		User user = userService.login(dto.getUsername().trim(), dto.getPassword().trim());
		if (null == user) {
			return ResultInfo.fail("账号或密码输入有误");
		}
		SessionUtil.setUser(request, user);
		return ResultInfo.success();
	}

	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionUtil.delUser(request);
		response.sendRedirect("/cms/login");
	}

}
