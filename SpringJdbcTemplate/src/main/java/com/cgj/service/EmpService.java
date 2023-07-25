package com.cgj.service;

import com.cgj.pojo.Emp;

import java.util.List;

public interface EmpService {
    int findEmpCount();

    String findByEmpno(Double empno);

    List<Emp> findByDeptno(int deptno);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp(int empno);
}
