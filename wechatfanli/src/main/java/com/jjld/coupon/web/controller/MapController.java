package com.jjld.coupon.web.controller;

import com.jjld.coupon.framework.util.PublicStatic;
import com.jjld.coupon.web.entity.Category;
import com.jjld.coupon.web.entity.Goods;
import com.jjld.coupon.web.entity.WebSite;
import com.jjld.coupon.web.query.CategoryQuery;
import com.jjld.coupon.web.query.GoodsQuery;
import com.jjld.coupon.web.service.CategoryService;
import com.jjld.coupon.web.service.GoodsService;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 网站地图
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sitemap", method = RequestMethod.GET)
    public ModelAndView sitemap() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Category> cateall = categoryService.pageList(new CategoryQuery());
        List<Goods> goods = goodsService.pageList(new GoodsQuery());
        map.put("cateall", cateall);
        map.put("goods", goods);
        map.put("web", PublicStatic.web);
        return new ModelAndView("/sitemap", map);
    }

    /**
     * 网站地图xml
     *
     * @return
     */
    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    public void sitemapxml(HttpServletResponse response) {
        WebSite web = PublicStatic.web;
        List<Category> all = categoryService.pageList(new CategoryQuery());
        List<Goods> goods = goodsService.pageList(new GoodsQuery());

        response.setContentType("text/xml;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            StringBuilder buff = new StringBuilder();
            buff.append("<?xml version= \"1.0\" encoding=\"utf-8\"?>").append("\n");
            buff.append(
                    "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:mobile=\"http://www.baidu.com/schemas/sitemap-mobile/1/\">");
            buff.append("<url>");
            buff.append("<mobile:mobile type=\"pc,mobile\"/>");
            buff.append("<loc>" + web.getDomainname() + "</loc>");
            buff.append("<priority>1.00</priority>");
            buff.append("<changefreq>daily</changefreq>");
            buff.append("</url>");
            if (null != all && all.size() > 0) {
                for (int i = 0; i < all.size(); i++) {
                    buff.append("<url>");
                    buff.append("<mobile:mobile type=\"pc,mobile\"/>");
                    buff.append("<loc>" + web.getDomainname() + "/cate" + all.get(i).getFqcat() + "/" + "</loc>");
                    buff.append("<priority>0.90</priority>");
                    buff.append("<changefreq>daily</changefreq>");
                    buff.append("</url>");
                }
            }
            if (null != goods && goods.size() > 0) {
                for (int i = 0; i < goods.size(); i++) {
                    buff.append("<url>");
                    buff.append("<mobile:mobile type=\"pc,mobile\"/>");
                    buff.append("<loc>" + web.getDomainname() + "/cate" + goods.get(i).getFqcat() + "/" + goods.get(i).getItemid() + ".html" + "</loc>");
                    buff.append("<priority>0.80</priority>");
                    buff.append("<changefreq>daily</changefreq>");
                    buff.append("</url>");
                }
            }

            buff.append("</urlset>");

            out.print(buff.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 网站地图txt
     *
     * @return
     */
    @RequestMapping(value = "/sitemap.txt", method = RequestMethod.GET)
    public void sitemaptxt(HttpServletResponse response) {
        WebSite web = PublicStatic.web;
        List<Category> all = categoryService.pageList(new CategoryQuery());
        List<Goods> goods = goodsService.pageList(new GoodsQuery());
        try {
            PrintWriter out = response.getWriter();
            StringBuilder buff = new StringBuilder();
            buff.append(web.getDomainname()).append("\n");

            if (null != all && all.size() > 0) {
                for (int i = 0; i < all.size(); i++) {
                    buff.append(web.getDomainname() + "/cate" + all.get(i).getFqcat() + "/").append("\n");
                }
            }
            if (null != goods && goods.size() > 0) {
                for (int i = 0; i < goods.size(); i++) {
                    buff.append(web.getDomainname() + "/cate" + goods.get(i).getFqcat() + "/" + goods.get(i).getItemid() + ".html" + "").append("\n");
                }
            }
            out.print(buff.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
