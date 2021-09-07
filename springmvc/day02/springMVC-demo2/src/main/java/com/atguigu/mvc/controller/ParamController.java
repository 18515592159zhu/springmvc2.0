package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    ////形参位置的request表示当前请求 通过ServletAPI获取获取请求参数
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);//最终打印：username:admin,password:123456
        return "success";
    }

    //通过控制器方法的形参获取请求参数
    @RequestMapping("/testParam")
    public String testParam(String username, String password, String[] hobby) {
        //以String[] hobby数组的形式接收hobby，也可以使用String hobby进行接收
        //若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));//最终打印：username:admin,password:123456,hobby:[a, b, c]
        return "success";
    }

    @RequestMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username,
            String password,
            String[] hobby,
            //RequestHeader(value = "sayHaha", required = true, defaultValue = "haha") String host
            @RequestHeader(value = "Host") String host,
            @CookieValue("JSESSIONID") String JSESSIONID
    ) {
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));//username:admin,password:123,hobby:[a, b, c]
        System.out.println("Host:" + host);//Host:localhost:8080
        System.out.println("JSESSIONID" + JSESSIONID);
        return "success";
    }

    //通过POJO获取请求参数
    @RequestMapping(value = "/testBean",method = RequestMethod.POST)
    public String testBean(User user, HttpServletResponse response) {
        System.out.println("user:" + user);//最终结果-->User{id=null, username='张三', password='123', age=23, sex='男', email='123@qq.com'}
        return "success";
    }
}
