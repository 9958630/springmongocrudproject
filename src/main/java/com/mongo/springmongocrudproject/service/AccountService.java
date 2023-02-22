package com.mongo.springmongocrudproject.service;

import com.mongo.springmongocrudproject.DAO.AccountDAO;
import com.mongo.springmongocrudproject.mapper.AccountMapper;
import com.mongo.springmongocrudproject.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService {

    private AccountDAO accountDAO;
    private AccountMapper accountMapperImpl;

    @Autowired
    public AccountService(AccountDAO accountDAO, AccountMapper accountMapperImpl) {
        this.accountDAO = accountDAO;
        this.accountMapperImpl = accountMapperImpl;
    }

    public String saveAccountDetails(Account account) {
        com.mongo.springmongocrudproject.entity.Account accountEntity = accountMapperImpl.mapModelToEntity(account);
        com.mongo.springmongocrudproject.entity.Account accountDB = accountDAO.save(accountEntity);
        if(Objects.nonNull(accountDB)){
            return "Given record inserted successfully in mongoDB";
        }
        return null;
    }

   /* public List<Account> getAllAccountDetails() {
       List<com.mongo.springmongocrudproject.entity.Account> accountEntity =  accountDAO.findAll();
       return accountMapperImpl.listEntityToModel(accountEntity);
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        return accountMapperImpl.mapEntityToModel(accountDAO.findByAccountNumber(accountNumber));
    }*/
}
