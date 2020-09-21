package com.jdy.spring2020.scan.service.intf;


import com.jdy.spring2020.bean.Book;

import java.util.List;

public interface BookShopService {
    /**
     * 买书，下单
     * @param isbn
     * @param username
     * @return
     */
    Book buyBook(String isbn, String username);
}
