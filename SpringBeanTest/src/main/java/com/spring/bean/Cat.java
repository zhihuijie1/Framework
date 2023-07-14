package com.spring.bean;

public class Cat {
    Mouse mouse;
    String name;

    @Override
    public String toString() {
        return "Cat{" +
                "mouse=" + mouse +
                ", name='" + name + '\'' +
                '}';
    }

    public Cat() {
    }

    public Cat(Mouse mouse, String name) {
        this.mouse = mouse;
        this.name = name;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}