package com.hengshui;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//@SpringBootApplication //启动器
//@EnableDiscoveryClient //进行拉取服务
//@EnableCircuitBreaker //降级与熔断

@SpringCloudApplication //相当于以上三个
@EnableFeignClients //远程调用注解feign
public class FiveUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FiveUserConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced //负载均衡功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
