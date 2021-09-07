package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpControlelr {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody:" + requestBody);//requestBody:username=admin&password=1234
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        //当前requestEnity表示整个请求报文的信息
        System.out.println("requestHeader:" + requestEntity.getHeaders());
        System.out.println("resquestBody:" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponseBody(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }

    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody() {
        return "成功";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User(1001, "admin", "123456", 23, "男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + "," + password);
        return "hello,axios";
    }
}