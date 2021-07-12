package com.jjld.coupon.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.jjld.coupon.web.entity.RedEnvelope;
import com.jjld.coupon.web.query.RedEnvelopeQuery;
import com.jjld.coupon.web.service.RedEnvelopeService;

@Controller
@RequestMapping("/cms/redenvelope")
public class RedEnvelopeController extends BaseController<RedEnvelope> {

	@Autowired
	private RedEnvelopeService service;

	@RequestMapping("/{mode}/dispatch")
	public ModelAndView dispatch(HttpServletRequest request, @PathVariable String mode, Integer id) {
		Map<String, Object> model = new HashMap<>();
		model.put("mode", mode);
		if (DispatchMode.LIST_MODE.equals(mode)) {
			return new ModelAndView("/admin/redEnvelope/list", model);
		}
		if (DispatchMode.ADD_MODE.equals(mode)) {
			SessionUtil.setToken(request, MD5Util.makeToken());
			return new ModelAndView("/admin/redEnvelope/edit", model);
		}
		if (DispatchMode.UPDATE_MODE.equals(mode)) {
			SessionUtil.setToken(request, MD5Util.makeToken());
			model.put("info", service.findRedEnvelopeByid(id));
			return new ModelAndView("/admin/redEnvelope/edit", model);
		}
		return new ModelAndView("/admin/error");
	}

	@PostMapping("/pageList")
	@ResponseBody
	public ResultInfo pageList(HttpServletRequest request, RedEnvelopeQuery query) {
		GridPage<RedEnvelope> gridPage = new GridPage<>(service.pageList(query));
		return ResultInfo.success(gridPage);
	}

	@PostMapping("/add")
	@ResponseBody
	public ResultInfo add(HttpServletRequest request, RedEnvelope info) {
		if (isRepeatSubmit(request)) {
			return ResultInfo.fail("请勿重复提交");
		}
		return service.insert(info);
	}

	@PostMapping("/update")
	@ResponseBody
	public ResultInfo update(HttpServletRequest request, RedEnvelope info) {
		if (isRepeatSubmit(request)) {
			return ResultInfo.fail("请勿重复提交");
		}
		return service.update(info);
	}

	@PostMapping("/deletes")
	@ResponseBody
	public ResultInfo deletes(String ids) {
		service.deleteByIds(ids);
		return ResultInfo.success();
	}

}
