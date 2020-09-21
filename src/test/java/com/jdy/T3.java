package com.jdy;

import com.jdy.spring2020.bean.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.Map;

public class T3 {
    private ApplicationContext ctx = null;
    private NamedParameterJdbcTemplate template = null;

    {
        ctx = new ClassPathXmlApplicationContext("application.xml");
        template = (NamedParameterJdbcTemplate) ctx.getBean("namedTemplate");
    }

    /**
     * 通过Map对象传入
     */
    @Test
    public void test_Method01(){
        //:p、:bn 具名参数名字随便起，冒号+名字
        String sql = "UPDATE book SET price = :p WHERE book_name = :bn";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bn","book01");
        paramMap.put("p",1000);
        System.out.println(template.update(sql, paramMap));
    }

    /**
     * 通过SqlParameterSource对象传入
     */
    @Test
    public void test_Method02(){
        //模拟Service曾直接传递给Dao曾一个具体的对象。
        String sql = "UPDATE book SET price = :price WHERE book_name = :book_name";
        Book book = new Book(null,"book01",10000);
        //此时剧名参数名称必须好对象的属性名称保持一致
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(book);
        System.out.println(template.update(sql, sqlParameterSource));
    }

}
