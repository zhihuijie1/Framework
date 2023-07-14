package com.spring.bean;

public class Book {
    private String bname;
    private String bauthor;

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(String bname, String bauthor) {
        this.bname = bname;
        this.bauthor = bauthor;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }
}
