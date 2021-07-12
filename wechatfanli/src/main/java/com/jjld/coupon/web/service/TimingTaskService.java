package com.jjld.coupon.web.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jjld.coupon.framework.util.HttpUtil2;
import com.jjld.coupon.web.entity.Goods;

import lombok.extern.slf4j.Slf4j;

@Service
@EnableScheduling
@EnableAsync
@Slf4j
public class TimingTaskService {
	
	@Autowired
    private GoodsService goodsService;
	/**
	 * 6点到0点每10分钟拉一次数据
	 * 0,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23
	 */
	@Async
	@Scheduled(cron = "0 0/30 6-23 * * ?")//测试
	public void saveGoodsData() {
		try {
	        log.info(LocalDateTime.now()+" 定时任务定时拉取数据  对应的线程名: "+Thread.currentThread().getName());
	        String url = "http://v2.api.haodanku.com/itemlist/apikey/liuli/nav/3/cid/0/back/500";
	        String s = HttpUtil2.doGet(url);
	        log.info(s);
	        JSONObject json = JSON.parseObject(s);
	        String data = json.getString("data");
			List<Goods> goods = JSON.parseArray(data, Goods.class);
	        for(int i=0;i<goods.size();i++){
	        	try {
					Goods  good =  goods.get(i);
					if(null != good) {
						Goods  gd = goodsService.findByItemid(good.getItemid());
						if(null == gd) {
							good.setCreateTime(new Date());
							goodsService.insertGoods(good);
							log.info(LocalDateTime.now() + "TimingTask save ok "+JSON.toJSONString(good));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
