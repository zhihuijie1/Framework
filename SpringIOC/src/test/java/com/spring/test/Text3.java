package com.spring.test;

import java.util.List;

public class Text3 {

    //接口
    interface Court {
        void doCourt();
    }

    //被代理的类
    static class Person implements Court {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void doCourt() {
            System.out.println("我是你爷爷 -- " + name);
        }
    }

    //代理类
    static class Lawyer implements Court {
        private Person person;

        public Lawyer(Person person) {
            this.person = person;
        }

        @Override
        public void doCourt() {
            System.out.println(" ------ -- -- - -");
            System.out.println(" -- - - -- - -- ");
            this.person.doCourt();
            System.out.println(" -- - -- - - -- - ");
        }
    }

    public static void main(String[] args) {
        Person person = new Person("草泥马");
        person.doCourt();
        System.out.println("/////////分割线/////////");

        Court court = new Lawyer(person);
        court.doCourt();
    }
}
