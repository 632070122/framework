package com.hengshui.controller;
import com.hengshui.domain.User;
import com.hengshui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/quick")
public class QuickController {

    @Autowired
    private UserService userService;

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        log.debug("quick method is running");
        System.out.println("quick method is running");
        return "springBoot";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println("当前毫秒值"+time);
        List<User> all = userService.findAll();
        Date date1 = new Date();
        long time1 = date1.getTime();
        System.out.println("当前毫秒值"+time1);
        System.out.println("时间差是"+(time1-time));
        return all;
    }
}
