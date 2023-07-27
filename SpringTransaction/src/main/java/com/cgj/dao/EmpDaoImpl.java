package com.cgj.dao;

import com.cgj.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //批量的加
    @Override
    public int[] addEmps(List<Emp> emps) {
        String sql = "insert into student values(?,?,?,?,?)";
        List<Object[]> args = new LinkedList<>();
        for (Emp emp : emps) {
            Object[] arg = new Object[]{emp.getId(), emp.getName(), emp.getMath(), emp.getChinese(), emp.getChinese()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    //批量的删
    @Override
    public int[] deleteEmps(List<Integer> nubs) {
        String sql = "delete from student where id = ?";
        List<Object[]> args = new LinkedList<>();
        for (Integer nub : nubs) {
            Object[] arr = new Object[]{nub};
            args.add(arr);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    //批量的查
    @Override
    public List<Emp> findEmps(List<Integer> nubs) {
        /*String sql = "select * from student where id = ?";
        List<Object[]> args = new ArrayList<>();
        for (Integer index : nubs) {
            Object[] arg = {index};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);*/
        return null;
    }
}