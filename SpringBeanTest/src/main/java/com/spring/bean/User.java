package com.spring.bean;

public class User {
    private Integer userid;
    private String username;
    private String password;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        System.out.println("setUserid");
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("setUsername");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword");
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
        System.out.println("无参构造器");
    }

    public User(Integer userid, String username, String password) {
        System.out.println("有参构造器");
        this.password = password;
        this.userid = userid;
        this.username = username;
    }
}
