package com.jjld.coupon.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jjld.coupon.framework.base.BaseController;
import com.jjld.coupon.framework.common.DispatchMode;
import com.jjld.coupon.framework.common.GridPage;
import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.util.MD5Util;
import com.jjld.coupon.framework.util.SessionUtil;
import com.jjld.coupon.web.dto.PassDTO;
import com.jjld.coupon.web.entity.User;
import com.jjld.coupon.web.query.SysUserQuery;
import com.jjld.coupon.web.service.UserService;

@Controller
@RequestMapping("/cms")
public class UserController extends BaseController<Object>{
 
	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/admin/index");
	}

	@GetMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("/admin/welcome");
	}

	@GetMapping("/error")
	public ModelAndView error() {
		return new ModelAndView("/admin/error");
	}

	@RequestMapping("/sysUser/{mode}/dispatch")
	public ModelAndView dispatch(HttpServletRequest request, @PathVariable String mode) {
		User user = SessionUtil.getUser(request);
		Map<String, Object> model = new HashMap<>();
		model.put("mode", mode);
		if (DispatchMode.LIST_MODE.equals(mode)) {
            return new ModelAndView("/admin/sysUser/list", model);
        }
		if (DispatchMode.UPDATE_MODE.equals(mode)) {
			SessionUtil.setToken(request, MD5Util.makeToken());
			model.put("sysUser", userService.findUserById(user.getId()));
			return new ModelAndView("/admin/sysUser/edit", model);
		}
		if (DispatchMode.PROFILE_MODE.equals(mode)) {
			SessionUtil.setToken(request, MD5Util.makeToken());
			model.put("sysUser", userService.findUserById(user.getId()));
			return new ModelAndView("/admin/sysUser/profile", model);
		}
		if (DispatchMode.PASS_MODE.equals(mode)) {
			SessionUtil.setToken(request, MD5Util.makeToken());
			return new ModelAndView("/admin/sysUser/pass", model);
		}
		return new ModelAndView("/admin/error");
	}
	
 
	
    @PostMapping("/sysUser/pageList")
    @ResponseBody
    public ResultInfo pageList(SysUserQuery query) {
        GridPage<User> gridPage = new GridPage<>(userService.pageList(query));
        return ResultInfo.success(gridPage);
    }

  

    @PostMapping("/sysUser/update")
    @ResponseBody
    public ResultInfo update(HttpServletRequest request, User info) {
        if (isRepeatSubmit(request)) {
            return ResultInfo.fail("请勿重复提交");
        }
        userService.update(info);
        return ResultInfo.success();
    }
 

    @PostMapping("/sysUser/deletes")
    @ResponseBody
    public ResultInfo deletes(String ids) {
        if ("1".equals(ids)) {
            return ResultInfo.fail("管理员禁止删除！");
        }
        userService.deleteByIds(ids);
        return ResultInfo.success();
    }

	@PostMapping("/sysUser/profile")
	@ResponseBody
	public ResultInfo profile(HttpServletRequest request, User u) {
		u.setId(SessionUtil.getUser(request).getId());
		userService.update(u);
		SessionUtil.setUser(request, userService.findUserById(u.getId()));
		return ResultInfo.success();
	}

	@PostMapping("/sysUser/pass")
	@ResponseBody
	public ResultInfo pass(HttpServletRequest request, PassDTO dto) {
		if (StringUtils.isBlank(dto.getOldPass())) {
			return ResultInfo.fail("旧密码不能为空");
		}
		if (StringUtils.isBlank(dto.getNewPass())) {
			return ResultInfo.fail("新密码不能为空");
		}
		User oldUser = SessionUtil.getUser(request);
		oldUser.setPassword(dto.getOldPass());
		oldUser.setNewPassWord(dto.getNewPass());
		return userService.updatePwd(oldUser);
	}

}
