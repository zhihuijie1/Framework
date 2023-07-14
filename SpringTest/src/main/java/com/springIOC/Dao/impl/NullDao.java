package com.springIOC.Dao.impl;

import com.springIOC.Dao.EmpDao;

public class NullDao implements EmpDao {
    @Override
    public int addEmp() {
        System.out.println("sdasdasd");
        return 10;
    }
}