package com.cgj.test;

import com.cgj.config.SpringConfig;
import com.cgj.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    @Test
    public void get() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao bean = applicationContext.getBean("userimpl", UserDao.class);
        bean.addUser(1, "fucking fucked");
    }
}
