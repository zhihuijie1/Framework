package com.spring.test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test5 {

    interface Dinner {
        void eat(String foodName);

        void drink();
    }

    static class Person implements Dinner {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void eat(String foodName) {
            System.out.println(name + "正在吃" + foodName);
        }

        @Override
        public void drink() {
            System.out.println(name + "正在喝茶");
        }
    }

    static class Student implements Dinner {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public void eat(String foodName) {
            System.out.println(name + "正在食堂吃" + foodName);
        }

        @Override
        public void drink() {
            System.out.println(name + "正在喝可乐");
        }
    }

    public static void main(String[] args) {
        Dinner dinner = new Student("fucked you");

        ClassLoader classLoader = dinner.getClass().getClassLoader();
        Class<?>[] interfaces = dinner.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            //proxy -> 动态生成的代理对象本身，是在运行时动态生成的，并实现了目标接口。
            //在invoke方法中，可以使用proxy代理对象来调用被代理对象的方法

            //method -> 被调用的方法，注意是代理对象上的被调用的方法的引用。包含方法的基本信息（方法名，参数列表，返回值类型等）
            //在invoke方法中，可以使用method对象来获取方法的参数，方法名等信息，并决定是否对该方法进行特殊处理。

            //args -> 方法的参数
            //args是一个Object数组，包含被调用方法的参数，在invoke方法中可以使用args数组来获取实际参数，从而在代理对象上执行被调用方法。

            //需要注意的是，invoke 方法的返回值是 Object 类型。它代表了被调用方法的返回值，因为 invoke 方法要返回被调用方法的执行结果。
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                if (method.getName().equals("drink")) {
                    System.out.println("喝酒");
                    System.out.println("我日你大爷");
                    res = method.invoke(dinner, args);
                    System.out.println("这就喝完了，你奶奶");
                } else {
                    res = method.invoke(dinner, args);
                }
                return res;
            }
        };

        Dinner dinner1 = (Dinner) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        //ClassLoader loader
        //Class<?>[] interfaces
        //InvocationHandler h
        dinner1.drink();
    }
}