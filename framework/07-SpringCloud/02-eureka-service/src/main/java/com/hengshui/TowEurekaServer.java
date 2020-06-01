package com.hengshui;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 标记是eureka的服务
public class TowEurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(TowEurekaServer.class);
    }
}
