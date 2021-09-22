package com.springboot.demo;

import com.springboot.demo.config.BlogProperties;
import com.springboot.demo.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/")
    String index() {
//        return blogProperties.getName()+"——"+blogProperties.getTitle();
        return configBean.getName()+"——"+configBean.getTitle();
    }
}
