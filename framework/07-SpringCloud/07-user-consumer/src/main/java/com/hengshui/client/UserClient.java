package com.hengshui.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping("user/{userId}")
    String queryById(@PathVariable("userId") Integer userId);

}
