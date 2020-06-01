package com.hengshui.client.impl;
import com.hengshui.client.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public String queryById(Integer userId) {
        return "服务器正忙";
    }
}
