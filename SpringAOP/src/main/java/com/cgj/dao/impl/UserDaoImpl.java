package com.cgj.dao.impl;

import com.cgj.dao.UserDao;
import org.springframework.stereotype.Repository;


@Repository("userimpl")
public class UserDaoImpl implements UserDao {
    public int addUser(Integer userid,String username){
        System.out.println("userDao add ----- ");
        return 1;
    }

    public int deleteUser(String name) {
        System.out.println("fuck ing fun csad");
        return 9;
    }
}
