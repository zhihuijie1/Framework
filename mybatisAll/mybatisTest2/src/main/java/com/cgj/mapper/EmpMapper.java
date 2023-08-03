package com.cgj.mapper;

import com.cgj.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    /*查询数据库中所有的成员信息*/
    List<Emp> findAllEmps();

    /*删除数据库中一个成员*/
    void deleteEmp(int empno);
}
