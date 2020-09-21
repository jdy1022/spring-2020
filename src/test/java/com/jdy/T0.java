package com.jdy;

import com.jdy.spring2020.bean.Book;
import com.jdy.spring2020.bean.Car;
import com.jdy.spring2020.bean.Person;
import com.jdy.spring2020.bean.Student;
import com.jdy.spring2020.proxy.CalculProxy;
import com.jdy.spring2020.scan.service.intf.ArithmeticCalculator;
import com.jdy.spring2020.scan.service.impl.ArithmeticCalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T0 {

    @Test
    public void test_method01() {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        Student student = (Student) context.getBean("student");
        System.out.println("student = " + student);

    }


    @Test
    public void test_method02() {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        Book book = (Book) context.getBean("myFactoryBean");
        System.out.println("book = " + book);

    }



    @Test
    public void test_method03() {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        Book book0 = (Book) context.getBean("book0");
        System.out.println("book0 = " + book0);
        Book book1 = (Book) context.getBean("book1");
        System.out.println("book1 = " + book1);

    }


    @Test
    public void test_method04() {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


    @Test
    public void test_method05() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println("car = " + car);
        context.close();
    }


    @Test
    public void test_method06() {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println("person = " + person);

    }


    @Test
    public void test_method07() {

        //第一步：获取目标对象
        ArithmeticCalculatorImpl calculService = new ArithmeticCalculatorImpl();
        //第二步：获取代理对象
        CalculProxy calculProxy = new CalculProxy(calculService);
        ArithmeticCalculator proxy = (ArithmeticCalculator)calculProxy.getObject(calculService);
        proxy.add(1,2);
    }
}
