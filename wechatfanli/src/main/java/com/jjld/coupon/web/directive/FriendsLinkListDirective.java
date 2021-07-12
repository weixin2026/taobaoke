package com.jjld.coupon.web.directive;

import com.jjld.coupon.web.entity.FriendsLink;
import com.jjld.coupon.web.service.FriendsLinkService;
import freemarker.core.Environment;
import freemarker.template.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Felix on 2019/2/22.
 */
@Component
@Slf4j
public class FriendsLinkListDirective implements TemplateDirectiveModel {

    @Autowired
    private FriendsLinkService friendsLinkService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapper objectWrapper = new DefaultObjectWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build();
        environment.setVariable("friendsLinkList", objectWrapper.wrap(list(map)));
        templateDirectiveBody.render(environment.getOut());
    }

    private List<FriendsLink> list(Map map) {
        return friendsLinkService.list();
    }

}
