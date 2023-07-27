package com.cgj.Test;

import com.cgj.pojo.Emp;
import com.cgj.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    @Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        EmpService bean = applicationContext.getBean(EmpService.class);
        /*List<Emp> emps = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            Emp emp = new Emp(i + 7, "killer" + i, i * 3 + 2.5, i * 3 + 2.5, i * 3 + 2.5);
            emps.add(emp);
        }
        System.out.println(Arrays.toString(bean.addEmps(emps)));*/

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        System.out.println(bean.findEmps(list));
    }
}
