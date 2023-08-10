package com.cgj.Test;

import com.cgj.mapper.EmpMapper;
import com.cgj.mapper.EmpMapper2;
import com.cgj.mapper.EmpMapper3;
import com.cgj.pojo.Dept;
import com.cgj.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Test1 {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //SqlSessionFactoryBuilder是MyBatis框架中的一个辅助类，用于构建SqlSessionFactory。
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //使用Resources工具类从类路径中获取sqlMapConfig.xml配置文件的输入流。
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //通过sqlSessionFactoryBuilder对象的build方法，将inputStream作为参数构建出SqlSessionFactory对象。
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //通过sqlSessionFactory对象的openSession方法，创建一个SqlSession对象。
        //SqlSession是MyBatis的核心会话类，用于执行数据库操作，比如执行SQL语句、提交事务等。
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        /*List<Emp> emps = mapper.findByEmpnoAndSal(10, 1000.0);
        emps.forEach(System.out::println);*/

        HashMap<String, Object> map = new HashMap<>();
        map.put("dno", 10);
        map.put("salary", 1000.0);
        List<Emp> emps = mapper.findByDeptnoAndSal2(map);
        emps.forEach(System.out::println);


        /*Emp emp = new Emp();
        emp.setDeptno(10);
        emp.setSal(1000.0);
        List<Emp> emps3 = mapper.findByDeptnoAndSal3(emp);
        emps3.forEach(System.out::println);*/

        /*Emp emp1 = new Emp();
        Emp emp2 = new Emp();
        emp1.setDeptno(10);
        emp2.setSal(1000.0);
        List<Emp> emps = mapper.findByDeptnoAndSal4(emp1, emp2);
        emps.forEach(System.out::println);*/
    }

    @Test
    public void testFindByEname() {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        List<Emp> a = mapper.findByEname("a");
        a.forEach(System.out::println);
    }

    @Test
    public void test2() {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        int i = mapper.addDept2(new Dept(null, "fuckingfucked", "123123123"));
        System.out.println(i);
        sqlSession.commit();
    }

    @Test
    public void test3() {
        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);
        int i = mapper.updateEnameByEmpno(7369, "滚你妈");
        System.out.println(i);
        System.out.println(i);
        sqlSession.commit();
    }


    @Test
    public void test4() {
        EmpMapper3 mapper = sqlSession.getMapper(EmpMapper3.class);
        int i = mapper.deleteByEmpno(7934);
        System.out.println(i);
        System.out.println(i);
        sqlSession.commit();
    }


    @After
    public void after() {
        //关闭SqlSession对象，释放数据库连接资源。在使用完SqlSession后，务必及时关闭，以防止资源泄漏。
        sqlSession.close();
    }
    //C:\Users\86159\AppData\Local\New Technology Studio\Apps\OpenIV\
}
