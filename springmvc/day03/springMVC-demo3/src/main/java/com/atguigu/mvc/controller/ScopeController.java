package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    //使用servletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello,servletAPI");
        return "success";
    }

    //使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mv = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mv.addObject("testRequestScope", "hello,ModelAndView");
        //设置视图名称
        mv.setViewName("success");
        return mv;
    }

    //使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,model");//org.springframework.validation.support.BindingAwareModelMap
        System.out.println(model.getClass().getName());
        return "success";
    }

    //使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,map");
        System.out.println(map.getClass().getName());//org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    //使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        System.out.println(modelMap.getClass().getName());//org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    //向session域共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}