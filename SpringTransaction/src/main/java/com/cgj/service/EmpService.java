package com.cgj.service;

import com.cgj.pojo.Emp;

import java.util.List;

public interface EmpService {
    int[] addEmps(List<Emp> emps);

    int[] deleteEmps(List<Integer> nubs);

    List<Emp> findEmps(List<Integer> nubs);
}
