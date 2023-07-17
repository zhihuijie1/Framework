package com.spring.dao.impl;

import com.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplA implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImplA ---  add ");
    }
}
