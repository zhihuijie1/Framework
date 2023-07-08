package com.spring.bean.test;

import com.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    @Test
    public void getBean() {
        //
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        User user = (User)applicationContext.getBean("user1");
        System.out.println(user);
    }
}
