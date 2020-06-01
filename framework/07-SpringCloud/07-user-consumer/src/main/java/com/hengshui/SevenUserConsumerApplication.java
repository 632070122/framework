package com.hengshui;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication //启动器
//@EnableDiscoveryClient //进行拉取服务
//@EnableCircuitBreaker //降级与熔断

@SpringCloudApplication //相当于以上三个
@EnableFeignClients //远程调用注解feign
public class SevenUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SevenUserConsumerApplication.class,args);
    }
}
