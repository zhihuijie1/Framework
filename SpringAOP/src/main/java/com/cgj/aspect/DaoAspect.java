package com.cgj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {

    //前置通知
    @Before("execution(* com.cgj.dao.impl.UserDaoImpl.addUser(..))")
    public void beforeAspect() {
        System.out.println("我是前置通知");
    }
}
