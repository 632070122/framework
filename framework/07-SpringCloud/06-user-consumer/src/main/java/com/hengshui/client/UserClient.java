package com.hengshui.client;
import com.hengshui.client.impl.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "user-service",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("user/{userId}")
    String queryById(@PathVariable("userId") Integer userId);

}
