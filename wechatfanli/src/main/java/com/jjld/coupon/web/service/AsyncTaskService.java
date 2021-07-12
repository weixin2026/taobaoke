package com.jjld.coupon.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.jjld.coupon.framework.util.BaiduUtil;
import com.jjld.coupon.framework.util.PublicStatic;
import com.jjld.coupon.web.entity.WebSite;

@Service
@EnableAsync
public class AsyncTaskService {
	/**
	 * 
	 * @param itemid
	 * @param cateid
	 * @param type   0是栏目 1是详情
	 * @param pageNo
	 */
	@Async
	public void postUrl2BaiDu(Integer itemid, Integer cateid, Integer type, Integer pageNo) {
		WebSite web = PublicStatic.web;
		String domain = web.getDomainname();
		String postUrl = web.getBaidupushurl();
		if (!StringUtils.isBlank(postUrl)) {
			if (!StringUtils.isBlank(domain) && domain.startsWith("http")) {
				if (domain.endsWith("/")) {
					domain = domain.substring(0, domain.length() - 1);
				}
				if (null != cateid && null != type) {
					List<String> urls = new ArrayList<>();
					String url = "";
					if (0 == type) {// 栏目
						if (null != pageNo && pageNo > 1) {
							url = domain + "/cate" + cateid + "/" + pageNo + "/";
						} else {
							url = domain + "/cate" + cateid + "/";
						}

					} else {// 详情页
						if (null != itemid) {
							url = domain + "/cate" + cateid + "/" + itemid + ".html";
						}
					}
					if (!StringUtils.isBlank(url)) {
						urls.add(url);
						BaiduUtil.push(urls, postUrl);
					}
				}
			}
		}
	}

}
