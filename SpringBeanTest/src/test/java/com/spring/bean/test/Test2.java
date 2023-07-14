package com.spring.bean.test;

import com.spring.bean.Cat;
import com.spring.bean.Mouse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    @Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Mouse mouse1 = applicationContext.getBean("mouse1", Mouse.class);
        System.out.println(mouse1);
        //Mouse{name='Jurry', birthday=Fri Jul 14 10:18:38 CST 2023}

        Cat cat1 = applicationContext.getBean("cat1", Cat.class);
        System.out.println(cat1);
        //Cat{mouse=Mouse{name='Jerry2', birthday=Fri Jul 14 10:29:57 CST 2023}, name='Tom'}

        Cat cat2 = applicationContext.getBean("cat2", Cat.class);
        System.out.println(cat2);
        //Cat{mouse=Mouse{name='jack', birthday=Fri Jul 14 10:36:57 CST 2023}, name='Tom2'}
    }

}

