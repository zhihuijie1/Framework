package com.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user1")
public class User {
    @Value("${user_a}")
    private Integer a;
    @Value("${user_b}")
    private String b;
    @Value("${user_c}")
    private Double c;

    public Integer getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public Double getC() {
        return c;
    }
}
