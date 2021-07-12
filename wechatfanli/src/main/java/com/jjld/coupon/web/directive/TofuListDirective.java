package com.jjld.coupon.web.directive;

import com.jjld.coupon.web.entity.Tofu;
import com.jjld.coupon.web.query.TofuQuery;
import com.jjld.coupon.web.service.TofuService;
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
public class TofuListDirective implements TemplateDirectiveModel {

    @Autowired
    private TofuService tofuService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapper objectWrapper = new DefaultObjectWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build();
        environment.setVariable("tofuList", objectWrapper.wrap(list(map)));
        templateDirectiveBody.render(environment.getOut());
    }

    private List<Tofu> list(Map map) {
        Object status = map.get("status");
        TofuQuery query = new TofuQuery();
        if (status != null) {
            query.setStatus(Integer.valueOf(String.valueOf(status)));
        }
        return tofuService.list(query);
    }

}
