package com.springboot.controller;

import com.springboot.config.BlogProperties;
import com.springboot.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootIndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/description")
    public String rootIndex() {
//        return blogProperties.getName()+"——"+blogProperties.getTitle();
        return configBean.getName()+"——"+configBean.getTitle();
//          return "hello spring boot";

    }
}
