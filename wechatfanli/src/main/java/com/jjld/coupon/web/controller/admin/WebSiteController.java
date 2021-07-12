package com.jjld.coupon.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.jjld.coupon.web.entity.WebSite;
import com.jjld.coupon.web.service.CommonService;
import com.jjld.coupon.web.service.WebSiteService;

@Controller
@RequestMapping("/cms/website")
public class WebSiteController extends BaseController<Object> {
	@Autowired
	private WebSiteService webSiteService;
	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/toedit", method = RequestMethod.GET)
	public ModelAndView toedit(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		WebSite info = webSiteService.getSystemSettings();
		map.put("entity", info);
		SessionUtil.setToken(request, MD5Util.makeToken());
		return new ModelAndView("/admin/sys/website", map);
	}

	@ResponseBody
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
	public ResultInfo edit(HttpServletRequest request, WebSite info) {
		if (isRepeatSubmit(request)) {
			return ResultInfo.fail("请勿重复提交");
		}

		String res = "success";
		if (info.getId() != null && info.getId() > 0) {
			res = webSiteService.update(info);
		} else {
			res = webSiteService.insert(info);
		}
		if (!res.equals("success")) {
			return ResultInfo.fail("失败");
		}
		commonService.cacheWebData();
		return ResultInfo.success();
	}

}
