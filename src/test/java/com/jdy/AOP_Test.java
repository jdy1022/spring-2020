package com.jdy;

import com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP_Test {

    @Test
    public void test_method01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ArithmeticCalculatorImpl service = context.getBean("arithmeticCalculatorImpl", ArithmeticCalculatorImpl.class);
        int add = service.add(1, 2);
        int sub = service.sub(1, 0);
    }
}
