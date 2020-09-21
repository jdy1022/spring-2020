package com.jdy.spring2020.factorybean;

import com.jdy.spring2020.bean.Book;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        return new Book();
    }

    /**
     * 返回具体bean对象类型
     * @return
     */
    @Override
    public Class<Book> getObjectType() {
        return Book.class;
    }

    /**
     * 是否是单利
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
