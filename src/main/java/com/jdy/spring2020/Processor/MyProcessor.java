package com.jdy.spring2020.Processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean的购置处理器：对IOC容器中所有的bean都起作用
 */
public class MyProcessor implements BeanPostProcessor {

    public static final String TITLE="Bean后置处理器";
    /**
     *在bean的生命周期的初始化方法之前执行
     * @param bean  正在被创建的bean对象
     * @param beanName  bean对象的id属性值
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(TITLE+"-Before方法......");
        return bean;
    }

    /**
     * bean的生命周期的初始化方法之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(TITLE+"-After方法......");
        return bean;
    }


}
