package com.spring.bean.test;

import com.spring.bean.BeanFactory;
import com.spring.bean.Book;
import com.spring.bean.Student;
import com.spring.bean.User;
import jdk.internal.org.objectweb.asm.util.ASMifiable;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test3 {
    @Test
    public void getBean() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Student student1 = applicationContext.getBean("student1", Student.class);
        System.out.println(student1.getBookList());
        System.out.println("---------------------");
        System.out.println(student1.getBookList2());
        System.out.println("---------------------");
        System.out.println(student1.getBookMap());
        System.out.println("---------------------");
        System.out.println(Arrays.toString(student1.getBooks()));
        System.out.println("---------------------");
        System.out.println(student1.getBookSet());

        Book book = applicationContext.getBean("factory", Book.class);
        System.out.println(book);

        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext1.getBean("user", User.class);
        System.out.println("获取bean");
        ((ClassPathXmlApplicationContext)applicationContext1).close();
    }
}
