package com.jdy.spring2020.scan.dao.impl;

import com.jdy.spring2020.bean.Book;
import com.jdy.spring2020.scan.dao.intf.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Book findBookPriceByIsbn(String isbn) {
        String sql = "SELECT * FROM book WHERE isbn=?";
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
        return template.queryForObject(sql, rowMapper, isbn);
    }

    @Override
    public int updateBookStock(String isbn) {
        //判断库存是否足够
        String sql = "SELECT stock from book_stock WHERE isbn = ?";
        Integer bookCount = template.queryForObject(sql, Integer.class, isbn);
        if (bookCount <= 0) {
            throw new RuntimeException("库存不足，没有书了");
        }
        sql = "UPDATE book_stock SET stock = stock-1 WHERE isbn = ?";
        return template.update(sql, isbn);

    }

    @Override
    public int updateAccount(String username, Integer price) {
        //判断余额是否足够
        String sql = "SELECT balance from account WHERE username = ?";
        Integer balance = template.queryForObject(sql, Integer.class, username);
        if (balance <= 0) {
            throw new RuntimeException("余额不足");
        }
        sql = "UPDATE account  SET balance  = balance - ? WHERE username = ?";
        return template.update(sql, price, username);

    }
}
