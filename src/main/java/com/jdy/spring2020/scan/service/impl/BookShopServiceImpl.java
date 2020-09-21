package com.jdy.spring2020.scan.service.impl;

import com.jdy.spring2020.bean.Book;
import com.jdy.spring2020.scan.dao.intf.BookShopDao;
import com.jdy.spring2020.scan.service.intf.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookShopServiceImpl implements BookShopService{


    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 买书 :账户余额减少，库存减少
     * @param isbn
     * @param username
     * @param stock
     * @param balance
     * @return
     */
    @Transactional
    @Override
    public Book buyBook(String isbn, String username) {
        Book book  = bookShopDao.findBookPriceByIsbn(isbn);
        Integer price = book.getPrice();
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateAccount(username,price);
        return book;
    }







}
