package com.cgj.mapper;
import com.cgj.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper3 {
    int addEmp(Emp emp);

    int updateEnameByEmpno(@Param("empnumber") int empno, @Param("empname") String ename);

    int deleteByEmpno(int empno);
}
