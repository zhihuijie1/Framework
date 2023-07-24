package com.cgj.test;

import com.cgj.dao.UserDao;
import com.cgj.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userimpl = applicationContext.getBean("userimpl");
        userimpl.deleteUser("dd");
        //userimpl.deleteUser("d");
        //userimpl.addUser(1,"d");
        System.out.println(userimpl.getClass().getSimpleName()); //得到对象对应的类名
    }
}
