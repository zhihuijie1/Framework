package com.cgj.service;

import com.cgj.dao.EmpDao;
import com.cgj.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpDao empDao;
    @Override
    public int findEmpCount() {
        return empDao.findEmpCount();
    }

    @Override
    public String findByEmpno(Double empno) {
        return empDao.findByEmpno(empno);
    }

    @Override
    public List<Emp> findByDeptno(int deptno) {
        return null;
    }

    @Override
    public int addEmp(Emp emp) {
        return 0;
    }

    @Override
    public int updateEmp(Emp emp) {
        return 0;
    }

    @Override
    public int deleteEmp(int empno) {
        return 0;
    }
}
