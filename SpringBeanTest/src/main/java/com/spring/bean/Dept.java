package com.spring.bean;

public class Dept {
    private Empt empt;

    @Override
    public String toString() {
        return "Dept{" +
                "empt=" + empt +
                '}';
    }

    public Empt getEmpt() {
        return empt;
    }

    public void setEmpt(Empt empt) {
        this.empt = empt;
    }
}
