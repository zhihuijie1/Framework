package com.springIOC.Dao.test;

import com.springIOC.Dao.EmpDao;
import com.springIOC.Dao.impl.NullDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    @Test
    //通过容器来获取对象。
    public void testGetBean() {
        //获取一个容器对象，并读取spring.xml文件，实例化配置文件中的对象后自动放入容器中。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //通过id从容器中获取对应的对象。
        EmpDao emptDao = (EmpDao) applicationContext.getBean("EmpDaoimpl");
        //第二种写法，后面的EmpDao.class的作用是告诉EmpDaoimpl所对应的值要强转成EmpDao类型。
        EmpDao empDaoimpl = applicationContext.getBean("EmpDaoimpl", EmpDao.class);
        //调用对象的方法。
        emptDao.addEmp();


        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        NullDao user2 = (NullDao)applicationContext.getBean("user2");
        user2.addEmp();
    }
}
