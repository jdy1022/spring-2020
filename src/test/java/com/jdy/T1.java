package com.jdy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T1 {

    @Test
    public void test_method01() {

        ApplicationContext context = new ClassPathXmlApplicationContext("application1.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
    }

}
