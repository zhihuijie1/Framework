package com.spring.bean.test;

import com.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test1 {

    @Test
    public void getTestBean() {
        //获取一个容器对象，读取配置文件，将文件中的对象通过反射的方法创建好之后自动放入容器中。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        User user1 = applicationContext.getBean("user1", User.class);
        System.out.println(user1);
        System.out.println("--------");

        User user2 = applicationContext.getBean("user2", User.class);
        System.out.println(user2);
        System.out.println("--------");

        User user3 = applicationContext.getBean("user3", User.class);
        System.out.println(user3);
        System.out.println("--------");

        User user4 = applicationContext.getBean("user4", User.class);
        System.out.println(user4);
        System.out.println("--------");
        User user5 = applicationContext.getBean("user5", User.class);
        System.out.println(user5);
    }
}
