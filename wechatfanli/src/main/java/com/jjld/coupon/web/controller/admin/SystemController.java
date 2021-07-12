package com.jjld.coupon.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jjld.coupon.framework.base.BaseController;
import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.util.MD5Util;
import com.jjld.coupon.framework.util.SessionUtil;
import com.jjld.coupon.web.entity.SystemSettings;
import com.jjld.coupon.web.service.CommonService;
import com.jjld.coupon.web.service.SystemSettingsService;

@Controller
@RequestMapping("/cms/system")
public class SystemController extends BaseController<Object> {
	@Autowired
	private SystemSettingsService systemSettingsService;
	
	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/toedit", method = RequestMethod.GET)
	public ModelAndView toedit(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		SystemSettings info = systemSettingsService.getSystemSettings();
		map.put("entity", info);
		SessionUtil.setToken(request, MD5Util.makeToken());
		return new ModelAndView("/admin/sys/systemsite", map);
	}

	@ResponseBody
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
	public ResultInfo add(HttpServletRequest request, SystemSettings info) {
		if (isRepeatSubmit(request)) {
			return ResultInfo.fail("请勿重复提交");
		}

		if (StringUtils.isEmpty(info.getTaoauthid()) || StringUtils.isEmpty(info.getPid())) {
			return ResultInfo.fail("淘宝授权ID或推广位PID不能为空");
		}
		
		String res = "success";
		if (info.getId() != null && info.getId() > 0) {
			res = systemSettingsService.update(info);
		} else {
			res = systemSettingsService.insert(info);
		}
		if (!res.equals("success")) {
			return ResultInfo.fail("失败");
		}
		commonService.cacheSysData();
		return ResultInfo.success();
	}

}
