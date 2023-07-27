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
    public int[] addEmps(List<Emp> emps) {
        return empDao.addEmps(emps);
    }

    @Override
    public int[] deleteEmps(List<Integer> nubs) {
        return empDao.deleteEmps(nubs);
    }

    @Override
    public List<Emp> findEmps(List<Integer> nubs) {
        return empDao.findEmps(nubs);
    }
}
