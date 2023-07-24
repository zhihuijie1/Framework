package com.cgj.test;

import com.cgj.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userimpl = applicationContext.getBean("userimpl", UserDao.class);
        userimpl.addUser(1,"fuck");
        System.out.println(userimpl.getClass().getSimpleName()); //得到对象对应的类名
    }
}
