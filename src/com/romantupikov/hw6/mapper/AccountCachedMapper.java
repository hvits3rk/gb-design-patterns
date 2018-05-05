package com.romantupikov.hw6.mapper;

import com.romantupikov.hw6.model.Account;

import java.util.HashMap;
import java.util.Collection;
import java.util.Map;

public class AccountCachedMapper implements AccountRepository {

    private final AccountMapper accountMapper;

    private final Map<Long, Account> cachedMap;
    
    private boolean allRetrieved = false;

    public AccountCachedMapper(AccountMapper accountMapper) {
        cachedMap = new HashMap<>();
        this.accountMapper = accountMapper;
    }

    @Override
    public Account create(Account account) {
        System.out.println("CachedMapper: create()");
        Account cachedAccount = cachedMap.getOrDefault(account.getId(), null);
        if (cachedAccount != null) {
            return cachedAccount;
        }

        Account createdAccount = accountMapper.create(account);
        if (createdAccount != null) {
            cachedMap.put(createdAccount.getId(), createdAccount);
        }

        return createdAccount;
    }

    @Override
    public Collection<Account> findAll() {
        System.out.println("CachedMapper: findAll()");
        if (!allRetrieved) {
            Collection<Account> accountCollection = accountMapper.findAll();
            for (Account account : accountCollection) {
                cachedMap.putIfAbsent(account.getId(), account);
            }
            allRetrieved = true;
            return accountCollection;
        }
        return cachedMap.values();
    }

    @Override
    public Account findById(Long id) {
        System.out.println("CachedMapper: findById()");
        Account cachedAccount = cachedMap.getOrDefault(id, null);
        if (cachedAccount != null) {
            return cachedAccount;
        }

        Account foundAccount = accountMapper.findById(id);
        if (foundAccount != null) {
            cachedMap.put(foundAccount.getId(), foundAccount);
        }

        return foundAccount;
    }

    @Override
    public Account update(Account account) {
        System.out.println("CachedMapper: update()");
        Account updatedAccount = accountMapper.update(account);
        if (updatedAccount != null) {
            Account cachedAccount = cachedMap.getOrDefault(account.getId(), null);
            if (cachedAccount != null) {
                cachedAccount.setId(account.getId());
                cachedAccount.setUsername(account.getUsername());
                cachedAccount.setPassword(account.getPassword());
                return cachedAccount;
            }
            cachedMap.put(updatedAccount.getId(), updatedAccount);
        }

        return updatedAccount;
    }

    @Override
    public Account delete(Account account) {
        System.out.println("CachedMapper: delete()");
        Account deletedAccount = accountMapper.delete(account);
        if (deletedAccount != null) {
            Account cachedAccount = cachedMap.getOrDefault(account.getId(), null);
            if (cachedAccount != null) {
                cachedMap.remove(cachedAccount.getId(), cachedAccount);
            }
        }

        return deletedAccount;
    }
}
