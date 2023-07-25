package com.spring;

import com.cgj.dao.EmpDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDao bean = applicationContext.getBean(EmpDao.class);
        System.out.println(bean.findEmpCount());
        System.out.println("1");
        System.out.println(bean.findByEmpno(70.5));
    }
}
