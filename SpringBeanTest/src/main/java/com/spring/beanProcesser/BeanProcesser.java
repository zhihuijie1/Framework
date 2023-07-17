package com.spring.beanProcesser;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanProcesser implements BeanPostProcessor {
    //在初始化方法之前
    //bean: 实例化的bean
    //beanName: bean的ID
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanProcesser之前");
        //必须要return bean
        return bean;
    }

    //在初始化方法之后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanProcesser之后");
        //必须要return bean
        return bean;
    }
}
