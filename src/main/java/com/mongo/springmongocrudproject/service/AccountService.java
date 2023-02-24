package com.mongo.springmongocrudproject.service;

import com.mongo.springmongocrudproject.DAO.AccountDAO;
import com.mongo.springmongocrudproject.mapper.AccountMapper;
import com.mongo.springmongocrudproject.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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

    public List<Account> getAllAccountDetails() {
       List<com.mongo.springmongocrudproject.entity.Account> accountEntity =  accountDAO.findAll();
       return accountMapperImpl.listEntityToModel(accountEntity);
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        List<com.mongo.springmongocrudproject.entity.Account> accountEntityList = accountDAO.findByAccountNumber(accountNumber);
        if(!CollectionUtils.isEmpty(accountEntityList) && accountEntityList.size()<=1){
           return  accountMapperImpl.mapEntityToModel(accountEntityList.stream().findFirst().get());

        }
        return null;
    }

    public List<Account> getAccountByAccNumAndAmount(String accountNumber,Integer amount) {
        List<com.mongo.springmongocrudproject.entity.Account> accountEntityList = accountDAO.findByAccountNumberAndAmount(accountNumber,amount);
            return  accountMapperImpl.listEntityToModel(accountEntityList);
    }

    public String updateAccount(Account account) {
        List<com.mongo.springmongocrudproject.entity.Account> accountList = accountDAO.findByAccountNumber(account.getAccountNumber());
        if(!CollectionUtils.isEmpty(accountList) && accountList.size()>1){
            return "Given accountNumber we found duplications please contact with your bank...!";
        }
        if(!CollectionUtils.isEmpty(accountList) && accountList.size()<=1){
            account.setId(accountList.stream().findFirst().get().getId());
            com.mongo.springmongocrudproject.entity.Account accountObj = accountDAO.save(accountMapperImpl.mapModelToEntity(account));
            if(Objects.nonNull(accountObj)){
                return "Updated successfully";
            }
        }
        return "Given accountNumber not found in database";
    }

    public String deleteAccount(String accountNumber) {
        List<com.mongo.springmongocrudproject.entity.Account> accountList = accountDAO.findByAccountNumber(accountNumber);
        if(!CollectionUtils.isEmpty(accountList) && accountList.size()>1){
            accountDAO.deleteAllByAccountNumber(accountNumber);
            return "Given accountNumber we found duplications but we deleted successfully...!";
        }
        com.mongo.springmongocrudproject.entity.Account account = accountDAO.deleteByAccountNumber(accountNumber);
        if(Objects.nonNull(account)){
            return "AccountNumber deleted successfully";
        }
        return "AccountNumber not found in DB";
    }

    public List<Account> getDateFilter(Date start){
        return accountMapperImpl.listEntityToModel(accountDAO.getDateFilter(start));
    }
}
