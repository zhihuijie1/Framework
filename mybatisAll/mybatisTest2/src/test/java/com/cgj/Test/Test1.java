package com.cgj.Test;

import com.cgj.mapper.EmpMapper;
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
import java.util.List;

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
        //获取到EmpMapper的实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.findAllEmps();
        emps.forEach(System.out::println);
        mapper.deleteEmp(7900);
    }
    @After
    public void after() {
        //关闭SqlSession对象，释放数据库连接资源。在使用完SqlSession后，务必及时关闭，以防止资源泄漏。
        sqlSession.close();
    }
}
