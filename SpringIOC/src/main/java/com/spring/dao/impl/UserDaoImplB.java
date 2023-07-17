package com.spring.dao.impl;

import com.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplB implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImplB ---  add ");
    }
}
