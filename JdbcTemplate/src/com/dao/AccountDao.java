package com.dao;

import com.bean.Account;

import java.util.List;

public interface AccountDao {
    Account getAccountByName(String name);

    List<Account> getAllAccount();

    boolean deleteAccount(String name);

    boolean updateAccount(Account account);

    boolean insertAccount(Account account);



}
