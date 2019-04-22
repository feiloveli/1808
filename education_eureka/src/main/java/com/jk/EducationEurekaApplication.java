package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * spring cloud的注册中心
 */
@SpringBootApplication
//标明此项目是注册中心
@EnableEurekaServer
public class EducationEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationEurekaApplication.class, args);
    }

}
