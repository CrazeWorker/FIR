package com.zc.ui;

/*
*
* 模拟一个表现层,用于调用业务层
*
* */

import com.zc.service.ICustomerService;
import com.zc.service.imp.CustomerServiceImp;

public class Client {
    public static void main(String[] args) {
        ICustomerService iCustomerService = new CustomerServiceImp();
        iCustomerService.saveCustomer();
    }
}
