package com.cgj.dao;

import com.cgj.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findEmpCount() {
        /**
         * 查询员工数量
         * queryForObject两个参数：
         * sql语句  返回值类型的class对象
         */
        Integer res = jdbcTemplate.queryForObject("select count(1) from student", Integer.class);
        return res;
    }

    @Override
    public String findByEmpno(Double empno) {
        /*
         * 查询单个员工对象
         * queryForObject三个参数
         * 1 SQL语句
         * 2 RowMapper接口的实现类对象,用于执行返回的结果用哪个类来进行封装 ,实现类为BeanPropertyRowMapper
         * 3 SQL语句中需要的参数 (可变参数)
         */
        BeanPropertyRowMapper<String> propertyRowMapper = new BeanPropertyRowMapper<>(String.class);
        String s = jdbcTemplate.queryForObject("select name from student where english = ?", propertyRowMapper, empno);
        return s;
    }

    @Override
    public List<Emp> findByDeptno(int deptno) {
        String sql = "select * from student where deptno = ?";
        //BeanPropertyRowMapper<> 返回的结果用哪个类来封装
        BeanPropertyRowMapper<Emp> propertyRowMapper = new BeanPropertyRowMapper<>(Emp.class);
        List<Emp> query = jdbcTemplate.query(sql, propertyRowMapper, deptno);
        return query;
    }

    @Override
    public int addEmp(Emp emp) {
        String sql = "insert into student values(?,?,?,?,?,?,?)";
        Object[] args = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()};
        int i = jdbcTemplate.update(sql, args);
        return i;
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql = "update emp set ename =? , job =?, mgr=? , hiredate =?, sal=?, comm=?, deptno =? where empno =?";
        Object[] args = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()};
        int i = jdbcTemplate.update(sql, args);
        return i;
    }

    @Override
    public int deleteEmp(int empno) {
        String sql = "delete  from emp where empno =?";
        int i = jdbcTemplate.update(sql, empno);
        return i;
    }
}
