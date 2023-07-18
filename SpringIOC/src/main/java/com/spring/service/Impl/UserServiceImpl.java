package com.spring.service.Impl;

import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImplA;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource(name="userDaoImplA")
    //@Autowired配合 @Qualifier,可以通过名称指定注入的对象
    public UserDao userDao;
    @Override
    public void add() {
        userDao.add();
        System.out.println("userService --- add ");
    }
}
