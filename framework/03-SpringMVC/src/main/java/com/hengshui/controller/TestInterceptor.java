package com.hengshui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class TestInterceptor {

    @RequestMapping("/abc")
    public String abc(){
        System.out.println("abc执行了");
        return "success";
    }
}
