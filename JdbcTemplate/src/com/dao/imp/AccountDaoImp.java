package com.dao.imp;

import com.bean.Account;
import com.dao.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.swing.*;
import java.util.List;

public class AccountDaoImp implements AccountDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountByName(String name) {
        List<Account> acc = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
        if (acc.size() != 0) {
            return acc.get(0);
        }
        JOptionPane.showMessageDialog(null,"没有此账户!");
        return null;
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }

    @Override
    public boolean deleteAccount(String name) {
        int update = jdbcTemplate.update("delete from account where name = ?", name);
        return update > 0;
    }

    @Override
    public boolean updateAccount(Account account) {
        int update = jdbcTemplate.update("update account set money = ? where name =?", account.getMoney(), account.getName());
        return update > 0;
    }

    @Override
    public boolean insertAccount(Account account) {
        int update = jdbcTemplate.update("insert into account(name ,money) values (?,?)", account.getName(), account.getMoney());
        return update > 0;
    }
}
