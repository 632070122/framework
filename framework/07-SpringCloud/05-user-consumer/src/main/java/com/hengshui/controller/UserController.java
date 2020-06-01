package com.hengshui.controller;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "defaultFallback")  //全局方法开启容错,线程隔离和线程降级
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")//开启失败容错,线程隔离和服务降级
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),//超时3秒就走熔断
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//断路器请求的量预值,10次统计一下,超过5次失败就认为有问题
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//休眠时间10秒
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//错误百分比,错误到达百分比就触发

            }
    )
    public String findById(@PathVariable("userId")Integer userId){
        String url = "http://user-service/user/"+userId;
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }

    public String defaultFallback(){
        return "服务器正忙......";
    }

}
