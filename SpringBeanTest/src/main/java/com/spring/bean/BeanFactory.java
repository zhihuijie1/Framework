package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class BeanFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Book book = new Book("深度学习","周志华");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
