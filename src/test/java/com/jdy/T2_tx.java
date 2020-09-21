package com.jdy;

import com.jdy.spring2020.bean.Book;
import com.jdy.spring2020.scan.dao.impl.BookShopDaoImpl;
import com.jdy.spring2020.scan.dao.intf.BookShopDao;
import com.jdy.spring2020.scan.service.impl.BookShopServiceImpl;
import com.jdy.spring2020.scan.service.intf.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class T2_tx {

    private BookShopDao bookShopDao;
    private BookShopService bookShopService;

    {
        ApplicationContext context = new ClassPathXmlApplicationContext("application_tx.xml");
        bookShopService= context.getBean("bookShopServiceImpl",BookShopServiceImpl.class);
        bookShopDao= context.getBean("bookShopDaoImpl", BookShopDaoImpl.class);
    }

    /**
     * 买书
     */
    @Test
    public void test_method01() {
        bookShopService.buyBook("ISBN-001","Jerry");
    }


}
