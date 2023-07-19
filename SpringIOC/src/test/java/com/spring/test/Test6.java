package com.spring.test;


import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test6 {

    interface food {
        void eat();
    }

    interface Book {
        void look(String name);

        void buy(int money);
    }

    static class Person implements Book {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void look(String name) {
            System.out.println("looking --- " + name);
        }

        @Override
        public void buy(int money) {
            System.out.println("buying ----- " + money);
        }
    }


    static class Student implements Book, food {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public void look(String name) {
            System.out.println(this.name + "stduent looking --- " + name);
        }

        @Override
        public void buy(int money) {
            System.out.println(this.name + "student buying ----- " + money);
        }

        @Override
        public void eat() {
            System.out.println("eating ----- ");
        }
    }


    public static void main(String[] args) {
        Book book = new Student("张三");

        Book book1 = (Book) Proxy.newProxyInstance(book.getClass().getClassLoader(), book.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                if (method.getName().equals("buy")) {
                    System.out.println("前加强");
                    res = method.invoke(book, args);//调用book对象buy方法传入的参数在args中
                    System.out.println("后加强");
                }else {
                    res = method.invoke(book, args);//调用book对象method方法(对应谁就是谁)传入的参数在args中
                }
                return res;
            }
        });

        book1.buy(1000);

        book1.look("小妹");

    }
}
