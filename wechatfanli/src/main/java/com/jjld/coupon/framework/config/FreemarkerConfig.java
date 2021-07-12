package com.jjld.coupon.framework.config;

import com.jjld.coupon.web.directive.*;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author SongFei
 * @date 2020/1/7 11:50
 */
@Configuration
public class FreemarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private CategoryListDirective categoryListDirective;

    @Autowired
    private NavigationListDirective navigationListDirective;

    @Autowired
    private BannerListDirective bannerListDirective;

    @Autowired
    private TofuListDirective tofuListDirective;

    @Autowired
    private FriendsLinkListDirective friendsLinkListDirective;

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        configuration.setSharedVariable("navigation_list", navigationListDirective);
        configuration.setSharedVariable("category_list", categoryListDirective);
        configuration.setSharedVariable("banner_list", bannerListDirective);
        configuration.setSharedVariable("tofu_list", tofuListDirective);
        configuration.setSharedVariable("friends_link_list", friendsLinkListDirective);
        // 取消默认数字格式化
        configuration.setNumberFormat("#");
    }

}
