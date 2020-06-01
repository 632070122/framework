package com.hengshui;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication //启动器
@MapperScan("com.hengshui.dao") //dao的扫描
@EnableDiscoveryClient //进行注册服务,注册到eureka,zookeeper
public class FourUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FourUserServiceApplication.class,args);
    }
}
