package com.cgj.apipassager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*表明这是一个控制器类，会接收Http请求并返回Http响应，
比较特别的是：这个控制器的每个方法的返回值都将直接作为HTTP响应的内容，而不是视图。*/
public class TestController {
    /* 是一个Spring框架的注解，用于将HTTP GET请求映射到控制器方法。
    在这个例子中，它将HTTP GET请求映射到下面的 test() 方法。
    "/test" 是HTTP请求的路径，当客户端发出GET请求时，Spring将路由到这个方法。*/
    @GetMapping("/test")
    public String test() {
        return "test api passager";
    }
}
