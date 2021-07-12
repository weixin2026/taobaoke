package com.jjld.coupon.web.controller;

import com.jjld.coupon.framework.base.BaseMap;
import com.jjld.coupon.framework.util.Tools;
import com.jjld.coupon.web.entity.Goods;
import com.jjld.coupon.web.service.CategoryService;
import com.jjld.coupon.web.service.GoodsService;
import com.jjld.coupon.web.service.TagService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商品
 *
 * @author SongFei
 * @date 2019/12/20 14:54
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/cate{fqcat}/{id}")
    public ModelAndView detail(HttpServletRequest request, @PathVariable Integer fqcat, @PathVariable Long id) {
        Map<String, Object> map = BaseMap.getBaseData();
        Goods goods = goodsService.findByItemid(id);
        map.put("goods", goods);
        map.put("tags", tagService.list());
        map.put("cate", categoryService.findCategoryByid(fqcat));
        map.put("guessGoodsList", goodsService.guessYouLike(fqcat, id));
        map.put("hotGoodsList", goodsService.sameProductsHot(fqcat, id));
        map.put("taobaoImageList", StringUtils.split(goods.getTaobaoImage(), ","));
        return new ModelAndView(Tools.getViewPath(request, "detail"), map);
    }

}
