package com.jjld.coupon.web.directive;

import com.jjld.coupon.web.entity.Category;
import com.jjld.coupon.web.query.CategoryQuery;
import com.jjld.coupon.web.service.CategoryService;
import freemarker.core.Environment;
import freemarker.template.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Felix on 2019/2/22.
 */
@Component
@Slf4j
public class CategoryListDirective implements TemplateDirectiveModel {

    @Autowired
    private CategoryService categoryService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapper objectWrapper = new DefaultObjectWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build();
        environment.setVariable("cateList", objectWrapper.wrap(list(map)));
        templateDirectiveBody.render(environment.getOut());
    }

    private List<Category> list(Map map) {
        Object status = map.get("status");
        CategoryQuery query = new CategoryQuery();
        if (status != null) {
            query.setStatus(Integer.valueOf(String.valueOf(status)));
        }
        return categoryService.list(query);
    }

}
