package com.jjld.coupon.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jjld.coupon.framework.base.BaseMap;
import com.jjld.coupon.framework.common.Constants;
import com.jjld.coupon.framework.common.PageUtil;
import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.util.HttpUtil2;
import com.jjld.coupon.framework.util.PublicStatic;
import com.jjld.coupon.framework.util.TbkUtil;
import com.jjld.coupon.framework.util.Tools;
import com.jjld.coupon.web.entity.Goods;
import com.jjld.coupon.web.query.GoodsQuery;
import com.jjld.coupon.web.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author SongFei
 * @date 2019/12/20 14:54
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TbkUtil tbkUtil;

    @Value("${tbk.center.domain}")
    private String tbkCenterDomain;

    @Value("${tbk.center.sp.url}")
    private String tbkCenterSpUrl;

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(HttpServletRequest request) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "index");
        map.put("plink", "/index/p/");
        map.put("mplink", "/p/index/");
        map.put("curr", Constants.DEFAULT_PAGE_NUM);

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));

        return new ModelAndView(Tools.getViewPath(request, "index"), map);
    }

    @GetMapping("/index/p/{page}")
    public ModelAndView indexPage(HttpServletRequest request, @PathVariable Integer page) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "index");
        map.put("plink", "/index/p/");
        map.put("curr", page);

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));

        return new ModelAndView(Tools.getViewPath(request, "index"), map);
    }

    @GetMapping("/p/index/{page}")
    @ResponseBody
    public ResultInfo pageIndex(@PathVariable Integer page) {
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer count = goodsService.count(goodsQuery);
        List<Goods> list = goodsService.pageList(goodsQuery);
        return ResultInfo.success(PageUtil.wrap(count, list, Constants.DEFAULT_PAGE_SIZE));
    }

    @GetMapping("/index/t/{sidx}/{sort}/{page}")
    public ModelAndView indexTpage(HttpServletRequest request, @PathVariable String sidx, @PathVariable String sort, @PathVariable Integer page) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "index");
        map.put("plink", "/index/t/" + sidx + "/" + sort + "/");
        map.put("mplink", "/p/index/t/" + sidx + "/" + sort + "/");
        map.put("curr", page);
        map.put("sidx", sidx);

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        goodsQuery.setSidx(sidx);
        goodsQuery.setSort(sort);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "index"), map);
    }

    @GetMapping("/p/index/t/{sidx}/{sort}/{page}")
    @ResponseBody
    public ResultInfo pageIndexT(@PathVariable String sidx, @PathVariable String sort, @PathVariable Integer page) {
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        goodsQuery.setSidx(sidx);
        goodsQuery.setSort(sort);
        Integer count = goodsService.count(goodsQuery);
        List<Goods> list = goodsService.pageList(goodsQuery);
        return ResultInfo.success(PageUtil.wrap(count, list, Constants.DEFAULT_PAGE_SIZE));
    }

    @GetMapping("/getTkl")
    @ResponseBody
    public ResultInfo getTkl(Long itemid, Integer type) {
        if (itemid == null || itemid <= 0) {
            return ResultInfo.fail("invalid parma");
        }
        Goods goods = goodsService.findByItemid(itemid);
        if (goods == null) {
            return ResultInfo.fail("goods not exist");
        }
        String s = HttpUtil2.doGet(tbkCenterDomain + tbkCenterSpUrl + "?token=" + Constants.CIPHER_KEY);
        if (StringUtils.isBlank(s)) {
            return ResultInfo.fail("param is missing");
        }
        ResultInfo info = JSON.parseObject(s, ResultInfo.class);
        if (info.getCode() != 1001) {
            return ResultInfo.fail("getsip fail");
        }
        String[] ss = StringUtils.split(String.valueOf(info.getData()), ":");
        //String sid = "25694";
        //String pid = "mm_116336152_1478100391_110209000254";
        String couponUrl = tbkUtil.getCouponUrl(ss[0], ss[1], itemid);
        String tkl = tbkUtil.getTkl(goods.getItemtitle(), goods.getItempic(), couponUrl);
        String str = "";
        if (type == 0) {
            str += "【" + PublicStatic.web.getWebname() + "】复制框内整段文字，打开「手机淘宝」即可「领取优惠券」并购买 " + tkl;
        } else {
            str += "【" + PublicStatic.web.getWebname() + "】" + goods.getItemtitle() + "<br>";
            str += "【原价】" + goods.getItemprice() + "元<br>";
            str += "【优惠券】" + goods.getCouponmoney() + "元<br>";
            str += "【券后价】" + goods.getItemendprice() + "元<br>";
            str += "【复制这条信息】，打开【手机淘宝】即可领券并下单 " + tkl + "<br>";
            str += goods.getItemdesc();
        }
        return ResultInfo.success(str);
    }

    @GetMapping("/su/cate{fqcat}/{id}")
    public void suitem(HttpServletResponse response, @PathVariable Integer fqcat, @PathVariable Long id) throws IOException {
        if (fqcat == null || id == null) {
            return;
        }
        Goods goods = goodsService.findByItemid(id);
        if (goods == null) {
            return;
        }
        String s = HttpUtil2.doGet(tbkCenterDomain + tbkCenterSpUrl + "?token=" + Constants.CIPHER_KEY);
        if (StringUtils.isBlank(s)) {
            return;
        }
        ResultInfo info = JSON.parseObject(s, ResultInfo.class);
        if (info.getCode() != 1001) {
            return;
        }
        String[] ss = StringUtils.split(String.valueOf(info.getData()), ":");
        JSONObject privilegeJson = tbkUtil.getPrivilege(ss[0], ss[1], id);
        if (privilegeJson == null) {
            return;
        }

        JSONObject jsonObject = privilegeJson.getJSONObject("tbk_privilege_get_response");
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject data = result.getJSONObject("data");
        String u_url = data.getString("coupon_click_url");
        String s_url = data.getString("item_url");

        if (goods.getCouponmoney().compareTo(new BigDecimal(0)) == 0) {
            log.info("优惠券金额为0，走s开头的链接");
            response.sendRedirect(s_url);
            return;
        }

        long currentTime = System.currentTimeMillis() / 1000;
        if (goods.getCouponstarttime() == null) {
            log.info("优惠券发放时间为空，走s开头的链接");
            response.sendRedirect(s_url);
            return;
        }
        if (currentTime > goods.getCouponendtime() || currentTime < goods.getCouponstarttime()) {
            log.info("当前不在优惠券发放时间内，走s开头的链接");
            response.sendRedirect(s_url);
            return;
        }

        if (StringUtils.isBlank(u_url)) {
            log.info("u开头的链接为空，走s开头的链接");
            response.sendRedirect(s_url);
            return;
        }

        response.sendRedirect(u_url);
    }

}
