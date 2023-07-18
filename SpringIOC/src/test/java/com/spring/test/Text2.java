package com.spring.test;

import com.spring.bean.User;
import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text2 {
    @Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        userService.add();
        User user = applicationContext.getBean("user1", User.class);
        System.out.println(user.getA());
        System.out.println(user.getB());
        System.out.println(user.getC());
    }
}
