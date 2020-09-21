package com.jdy.spring2020.scan.service.intf;

import java.util.List;

public interface Cashier {
    /**
     * 收银台结算
     * @param isbns
     * @param username
     */
    void checkOut(List<String> isbns, String username);
}
