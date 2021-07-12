package com.jjld.coupon.web.controller;

import com.jjld.coupon.framework.base.BaseMap;
import com.jjld.coupon.framework.common.Constants;
import com.jjld.coupon.framework.common.PageUtil;
import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.util.Tools;
import com.jjld.coupon.web.entity.Goods;
import com.jjld.coupon.web.query.GoodsQuery;
import com.jjld.coupon.web.service.GoodsService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SongFei
 * @date 2019/12/20 14:54
 */
@Controller
public class SearchController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/search")
    public ModelAndView search(HttpServletRequest request, String s) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("s", s);
        map.put("source", "search");
        map.put("plink", "/search/p/");
        map.put("mplink", "/p/search/");
        map.put("curr", Constants.DEFAULT_PAGE_NUM);

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setItemtitle(s);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "search"), map);
    }

    @GetMapping("/search/p/{page}")
    public ModelAndView searchPage(HttpServletRequest request, String s, @PathVariable Integer page) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("s", s);
        map.put("source", "search");
        map.put("plink", "/search/p/");
        map.put("curr", page);

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setItemtitle(s);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "search"), map);
    }

    @GetMapping("/p/search/{page}")
    @ResponseBody
    public ResultInfo pageSearch(String s, @PathVariable Integer page) {
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setItemtitle(s);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer count = goodsService.count(goodsQuery);
        List<Goods> list = goodsService.pageList(goodsQuery);
        return ResultInfo.success(PageUtil.wrap(count, list, Constants.DEFAULT_PAGE_SIZE));
    }

    @GetMapping("/search/t/{sidx}/{sort}/{page}")
    public ModelAndView indexTpage(HttpServletRequest request, String s, @PathVariable String sidx, @PathVariable String sort, @PathVariable Integer page) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "search");
        map.put("plink", "/search/t/" + sidx + "/" + sort + "/");
        map.put("mplink", "/p/search/t/" + sidx + "/" + sort + "/");
        map.put("curr", page);
        map.put("sidx", sidx);

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setItemtitle(s);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        goodsQuery.setSidx(sidx);
        goodsQuery.setSort(sort);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "search"), map);
    }

    @GetMapping("/p/search/t/{sidx}/{sort}/{page}")
    @ResponseBody
    public ResultInfo pageIndexT(String s, @PathVariable String sidx, @PathVariable String sort, @PathVariable Integer page) {
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setItemtitle(s);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        goodsQuery.setSidx(sidx);
        goodsQuery.setSort(sort);
        Integer count = goodsService.count(goodsQuery);
        List<Goods> list = goodsService.pageList(goodsQuery);
        return ResultInfo.success(PageUtil.wrap(count, list, Constants.DEFAULT_PAGE_SIZE));
    }

}
