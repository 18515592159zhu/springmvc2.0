package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {

    //@RequestMapping注解的value属性
    @RequestMapping(value = {"/testRequestMapping", "/test"})
    public String testRequestMapping() {
        return "success";
    }

    //@RequestMapping注解的method属性
    @RequestMapping(value = {"/testRequestMapping", "/test"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String testRequestMapping_1() {
        return "success";
    }

    //派生注解
    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    //测试form表单是否能够发送put或delete请求方式
    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    //@RequestMapping注解的params属性（了解）
    @RequestMapping(value = "/testParams", method = RequestMethod.GET, params = {"username", "password!=123456"})
    public String testParams() {
        return "success";
    }

    //@RequestMapping注解的headers属性（了解）
    @RequestMapping(value = "/testHeader", method = RequestMethod.GET, headers = {"Host=localhost:8080"})
    public String testHeader() {
        return "success";
    }

    // SpringMVC支持ant风格的路径（类似模糊）
    // ？：表示任意的单个字符
    @RequestMapping("/a?a/testAnt1")
    public String testAnt1() {
        return "success";
    }

    // *：表示任意的0个或多个字符
    @RequestMapping("/a*a/testAnt2")
    public String testAnt2() {
        return "success";
    }

    // **：表示任意的一层或多层目录
    @RequestMapping("/**/testAnt3")
    public String testAnt3() {
        return "success";
    }

    //SpringMVC支持路径中的占位符（重点）
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ",username:" + username);//最终输出的内容为-->id:1,username:admin
        return "success";
    }
}