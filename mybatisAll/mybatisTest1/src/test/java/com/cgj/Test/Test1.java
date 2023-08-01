package com.cgj.Test;

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
import java.util.*;

public class Test1 {
    private SqlSession sqlSession = null;

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

    /*@Test
    public void get() throws IOException {
        List<Dept> findAll = sqlSession.selectList("findAll");
        for (Dept dept : findAll) {
            System.out.println(dept);
        }
    }

    @Test
    public void findOne() {
        Emp findOne = sqlSession.selectOne("findOne");
        System.out.println(findOne);
    }

    @Test
    public void testSelectList() {
        // 查询多个对象的List集合
        System.out.println("sqlSession查询对象List集合");
        List<Emp> emps = sqlSession.selectList("EmpMapper.findAll");
        emps.forEach(System.out::println);
    }

    @Test
    public void testSelectMap() {
        System.out.println("sqlSession查询对象Map集合");
        Map<Integer, Emp> empMap = sqlSession.selectMap("findMap", "EMPNO");
        Set<Integer> empnos = empMap.keySet();
        for (Integer empno : empnos) {
            System.out.println(empno + "::" + empMap.get(empno));
        }
    }*/

    @Test
    public void testfindByEmpno() {
        // 测试单个基本数据类型作为参数
        Emp findByEmpno = sqlSession.selectOne("findByEmpno", 7782);
        System.out.println(findByEmpno);
    }

    @Test
    public void testfindEmpByDeptnoAndSal() {
        // 测试Map集合作为参数
        HashMap<String, Object> args = new HashMap<>();
        args.put("deptno", 20);
        args.put("mgr", 1300.0);
        List<Emp> findEmpByDeptnoAndSal = sqlSession.selectList("findEmpByDeptnoAndSal", args);
        for (Emp emp : findEmpByDeptnoAndSal) {
            System.out.println(emp);
        }
    }


    @After
    public void after() {
        //关闭SqlSession对象，释放数据库连接资源。在使用完SqlSession后，务必及时关闭，以防止资源泄漏。
        sqlSession.close();
    }
}
