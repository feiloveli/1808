package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.jk.mapper")
//可以往服务中心进行注册
@EnableDiscoveryClient
public class EducationProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationProducerApplication.class, args);
    }

}
