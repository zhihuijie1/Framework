package com.cgj.mapper;

import com.cgj.pojo.Dept;
import com.cgj.pojo.Emp;

import java.util.List;

public interface EmpMapper2 {
    List<Emp> findByEname(String ename);

    int addDept(Dept dept);

    int addDept2(Dept dept);
}
