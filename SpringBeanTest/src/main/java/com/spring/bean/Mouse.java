package com.spring.bean;

import java.util.Date;

public class Mouse {
    String name;
    Date birthday;

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Mouse() {
    }

    public Mouse(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
