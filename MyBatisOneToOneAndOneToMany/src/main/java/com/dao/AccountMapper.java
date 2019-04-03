package com.dao;

import com.bean.Account;
import com.bean.StudentAccount;

import java.util.List;

public interface AccountMapper {
    // 查询所有的订单的同时取出用户的基本信息
    List<Account> selectAllAccount();

    // 查询所有的订单的同时，拿到当前订单的用户姓名，专业
    List<StudentAccount> selectAllAccountAndStudent();
}
