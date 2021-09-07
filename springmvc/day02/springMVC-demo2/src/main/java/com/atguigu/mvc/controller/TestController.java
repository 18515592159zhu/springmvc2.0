package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
    /*@RequestMapping(value = "/testRequestMapping")
    public String testRequestMapping() {
        return "success";
    }*/

    @RequestMapping("/param")
    public String param() {
        return "test_param";
    }
}