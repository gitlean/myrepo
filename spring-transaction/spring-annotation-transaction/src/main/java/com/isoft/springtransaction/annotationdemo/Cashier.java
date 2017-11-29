package com.isoft.springtransaction.annotationdemo;

import java.util.List;
public interface Cashier {
    public void checkout(String username, List<String>isbns);
}