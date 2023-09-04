package com.cgj.apipassager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//springboot应用程序的入口，这个注解整合了很多其他的注解的功能，简化配置与启动springboot.
//功能：1：Spring配置类，它可以包含Bean定义。2：Spring Boot会根据你的项目的依赖和配置自动配置应用程序。
//3：告诉Spring Boot在包扫描中查找其他组件、配置和服务类
public class ApiPassagerApplication {
    public static void main(String[] args) {
        //启动springboot应用程序
        SpringApplication.run(ApiPassagerApplication.class);
    }
}
