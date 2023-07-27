package com.cgj.dao;

import com.cgj.pojo.Emp;

import java.util.List;

public interface EmpDao {

    int[] addEmps(List<Emp> emps);

    int[] deleteEmps(List<Integer> nubs);

    List<Emp> findEmps(List<Integer> nubs);
}
