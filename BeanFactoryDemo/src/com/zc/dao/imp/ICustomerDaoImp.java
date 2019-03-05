package com.zc.dao.imp;

import com.zc.dao.ICustomerDao;

public class ICustomerDaoImp implements ICustomerDao {
    @Override
    public void savaCustomer() {
        System.out.println("持久层的保存客户信息");
    }
}
