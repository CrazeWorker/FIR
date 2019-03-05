package com.zc.service.imp;

import com.zc.dao.ICustomerDao;
import com.zc.dao.imp.ICustomerDaoImp;
import com.zc.factory.BeanFactory;
import com.zc.service.ICustomerService;

public class CustomerServiceImp implements ICustomerService {

//    private ICustomerDao customerDao = new ICustomerDaoImp();

    // 工厂实例化变量（反射）
    private ICustomerDao iCustomerDao = ((ICustomerDao) BeanFactory.getBean("CUSTOMERDAO"));

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用了持久层");
        iCustomerDao.savaCustomer();
    }
}
