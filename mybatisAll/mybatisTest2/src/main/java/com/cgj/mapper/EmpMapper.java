package com.cgj.mapper;

import com.cgj.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

    /*查询数据库中所有的成员信息*/
    List<Emp> findAllEmps();

    /*删除数据库中一个成员*/
    void deleteEmp(int empno);

    /*根据员工编号来查询单个员工信息*/
    Emp findByEmpno(int empno);

    /*根据员工编号和薪资下限去查询员工信息*/
    List<Emp> findByEmpnoAndSal(@Param("p1") int deptno, @Param("p2") double sal);

    List<Emp> findByDeptnoAndSal2(Map<String,Object> map);

    List<Emp> findByDeptnoAndSal3(Emp emp);

    List<Emp> findByDeptnoAndSal4(@Param("empa") Emp empa, @Param("empb") Emp empb);

}
