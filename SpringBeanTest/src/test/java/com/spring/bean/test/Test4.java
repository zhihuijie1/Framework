package com.spring.bean.test;

import com.spring.bean.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    @Test
    public void getMethod() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dept dept1 = applicationContext.getBean("dept1", Dept.class);
        System.out.println(dept1);
        //Dept{empt=com.spring.bean.Empt@1f021e6c}
    }
}
