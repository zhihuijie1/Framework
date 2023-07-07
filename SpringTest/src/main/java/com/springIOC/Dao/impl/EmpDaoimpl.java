package com.springIOC.Dao.impl;

import com.springIOC.Dao.EmpDao;

public class EmpDaoimpl implements EmpDao {
    @Override
    public int addEmp() {
        System.out.println("add incoked");
        return 0;
    }
}
