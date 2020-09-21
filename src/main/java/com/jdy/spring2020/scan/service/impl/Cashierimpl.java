package com.jdy.spring2020.scan.service.impl;

import com.jdy.spring2020.bean.Book;
import com.jdy.spring2020.scan.service.intf.BookShopService;
import com.jdy.spring2020.scan.service.intf.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Cashierimpl implements Cashier  {

    @Autowired
    private BookShopService bookShopService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW ,isolation= Isolation.READ_COMMITTED,
            rollbackFor = {IOException.class, SQLException.class},
            noRollbackFor= {NullPointerException.class},
            readOnly = true,
            timeout = 30
            )
    public void checkOut(List<String> isbns, String username) {
        for (String isbn : isbns) {
            Book book  = bookShopService.buyBook(isbn,username);
        }
    }
}
