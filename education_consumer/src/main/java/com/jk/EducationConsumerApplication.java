package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//可以往服务中心进行注册
@EnableDiscoveryClient
//可以调用服务中心的项目
@EnableFeignClients
public class EducationConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationConsumerApplication.class, args);
    }

}
