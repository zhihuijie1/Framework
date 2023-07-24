package com.spring.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test7 {

    static class Person {
        static String name;

        public Person() {}

        public Person(String name) {
            this.name = name;
        }

        public void eat(String food) {
            System.out.println(name + "正在吃" + food);
        }
    }

    public static void main(String[] args) {
        Person person = new Person("fucked");
        //获取person的代理对象

        //Enhancer -> 一个媒介用来创建代理对象，在运行时生成目标类的子类，并拦截此类的调用方法以实现方法加强功能。
        Enhancer enhancer = new Enhancer();
        //传入父类的类加载器
        enhancer.setClassLoader(person.getClass().getClassLoader());
        //传入父类的字节码文件
        enhancer.setSuperclass(person.getClass());
        //进行方法拦截
        //MethodInterceptor->方法拦截器
        enhancer.setCallback(new MethodInterceptor() {
            //Object o -- 生成后代理对象自身
            //Method method -- 父类中要增强的方法
            //Object[] objects -- 方法参数列表
            //MethodProxy methodProxy -- 子类中重写父类的方法
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object res = null;
                if(method.getName().equals("eat")) {
                    System.out.println("增强前");
                    //在CGLIB动态代理中，当我们拦截代理对象的方法调用时，
                    //如果需要执行目标类的原始方法，就可以使用invokeSuper方法。
                    res = methodProxy.invokeSuper(o,objects);
                    System.out.println("增强后");
                }else {
                    res = methodProxy.invokeSuper(o,objects);
                }
                return res;
            }
        });
        //创建出代理对象
        Person person1 = (Person)enhancer.create();

        person1.eat("shi");
    }
}