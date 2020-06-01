package com.hengshui.controller;
import com.hengshui.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "defaultFallback")  //全局方法开启容错,线程隔离和线程降级
public class UserController {


    @Autowired
    private UserClient userClient;

    @GetMapping("/{userId}")//开启失败容错,线程隔离和服务降级
    @HystrixCommand //线程隔离和线程降级
    public String findById(@PathVariable("userId")Integer userId)  {
        String user = userClient.queryById(userId);
        System.out.println(user);
        return user;
    }

    public String defaultFallback(){
        return "服务器正忙......";
    }

}
