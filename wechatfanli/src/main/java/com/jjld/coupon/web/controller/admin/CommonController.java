package com.jjld.coupon.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jjld.coupon.framework.util.FileUtil;
import com.jjld.coupon.web.service.ConfigService;

@Controller
@RequestMapping("/cms")
public class CommonController {

	@Autowired
	private ConfigService configService;
	
	/**
	 * 图片上传
	 * 
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	public Map<String, Object> logUpload(@RequestParam(value = "myfile", required = true) MultipartFile file)
			throws Exception {
		Map<String, Object> data = null;
		try {
			String localPath = configService.getStrValue("local.filepath");
			data = FileUtil.saveFile(file, localPath);
		} catch (Exception e) {
			e.printStackTrace();
			data = new HashMap<String, Object>();
			data.put("code", 500);
		}
		return data;
	}
}
