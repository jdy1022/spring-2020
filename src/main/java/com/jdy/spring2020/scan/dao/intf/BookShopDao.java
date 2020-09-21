package com.jdy.spring2020.scan.dao.intf;


import com.jdy.spring2020.bean.Book;

public interface BookShopDao {

    /**
     * 根据书号查询书的价格
     */

    Book findBookPriceByIsbn(String isbn);

    /**
     * 根据书号查询书的价格
     * @param isbn
     * @param stock
     * @return
     */
    int updateBookStock(String isbn);

    /**
     * 根据书号查询书的价格
     * @param username
     * @param price
     * @return
     */
    int updateAccount(String username, Integer price);
}
