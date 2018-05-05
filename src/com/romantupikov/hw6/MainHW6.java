package com.romantupikov.hw6;

import com.romantupikov.hw6.db.MysqlDB;
import com.romantupikov.hw6.mapper.AccountCachedMapper;
import com.romantupikov.hw6.mapper.AccountMapper;
import com.romantupikov.hw6.mapper.AccountRepository;
import com.romantupikov.hw6.model.Account;

public class MainHW6 {

    public static void main(String[] args) {

        MysqlDB mysqlDB = new MysqlDB();

        AccountRepository accountRepository = new AccountCachedMapper(new AccountMapper(mysqlDB.getConnection()));

        accountRepository.findAll();

        Account account = accountRepository.findById(5L);
        System.out.println(account);

        account = accountRepository.findById(5L);
        System.out.println(account);

        account = accountRepository.findById(5L);
        System.out.println(account);

        accountRepository.findAll();

        mysqlDB.close();
    }
}
