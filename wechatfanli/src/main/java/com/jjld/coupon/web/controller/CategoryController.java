package com.jjld.coupon.web.controller;

import com.jjld.coupon.framework.base.BaseMap;
import com.jjld.coupon.framework.common.Constants;
import com.jjld.coupon.framework.common.PageUtil;
import com.jjld.coupon.framework.common.ResultInfo;
import com.jjld.coupon.framework.util.Tools;
import com.jjld.coupon.web.entity.Goods;
import com.jjld.coupon.web.query.GoodsQuery;
import com.jjld.coupon.web.service.CategoryService;
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
public class CategoryController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/cate{fqcat}")
    public ModelAndView cate(HttpServletRequest request, @PathVariable Integer fqcat) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "cate" + fqcat);
        map.put("plink", "/cate" + fqcat + "/p/");
        map.put("mplink", "/p/cate" + fqcat + "/");
        map.put("curr", Constants.DEFAULT_PAGE_NUM);

        map.put("cate", categoryService.findCategoryByid(fqcat));

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setFqcat(fqcat);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "catelist"), map);
    }

    @GetMapping("/cate{fqcat}/p/{page}")
    public ModelAndView catePage(HttpServletRequest request, @PathVariable Integer fqcat, @PathVariable Integer page) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "cate" + fqcat);
        map.put("plink", "/cate" + fqcat + "/p/");
        map.put("curr", page);

        map.put("cate", categoryService.findCategoryByid(fqcat));

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setFqcat(fqcat);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "catelist"), map);
    }

    @GetMapping("/p/cate{fqcat}/{page}")
    @ResponseBody
    public ResultInfo pageCate(@PathVariable Integer fqcat, @PathVariable Integer page) {
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setFqcat(fqcat);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        Integer count = goodsService.count(goodsQuery);
        List<Goods> list = goodsService.pageList(goodsQuery);
        return ResultInfo.success(PageUtil.wrap(count, list, Constants.DEFAULT_PAGE_SIZE));
    }

    @GetMapping("/cate{fqcat}/t/{sidx}/{sort}/{page}")
    public ModelAndView indexTpage(HttpServletRequest request, @PathVariable Integer fqcat, @PathVariable String sidx, @PathVariable String sort, @PathVariable Integer page) {
        Map<String, Object> map = BaseMap.getBaseData();
        map.put("source", "cate" + fqcat);
        map.put("plink", "/cate" + fqcat + "/t/" + sidx + "/" + sort + "/");
        map.put("mplink", "/p/cate" + fqcat + "/t/" + sidx + "/" + sort + "/");
        map.put("curr", page);
        map.put("sidx", sidx);

        map.put("cate", categoryService.findCategoryByid(fqcat));

        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setFqcat(fqcat);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        goodsQuery.setSidx(sidx);
        goodsQuery.setSort(sort);
        Integer totalCount = goodsService.count(goodsQuery);
        map.put("goodsPage", PageUtil.getTotalPage(totalCount, Constants.DEFAULT_PAGE_SIZE));
        map.put("goodsList", goodsService.pageList(goodsQuery));
        return new ModelAndView(Tools.getViewPath(request, "catelist"), map);
    }

    @GetMapping("/p/cate{fqcat}/t/{sidx}/{sort}/{page}")
    @ResponseBody
    public ResultInfo pageIndexT(@PathVariable Integer fqcat, @PathVariable String sidx, @PathVariable String sort, @PathVariable Integer page) {
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.setFqcat(fqcat);
        goodsQuery.setPageNum(page);
        goodsQuery.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        goodsQuery.setSidx(sidx);
        goodsQuery.setSort(sort);
        Integer count = goodsService.count(goodsQuery);
        List<Goods> list = goodsService.pageList(goodsQuery);
        return ResultInfo.success(PageUtil.wrap(count, list, Constants.DEFAULT_PAGE_SIZE));
    }

}
