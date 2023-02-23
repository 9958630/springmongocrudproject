package com.mongo.springmongocrudproject.DAO;

import com.mongo.springmongocrudproject.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO extends MongoRepository<Account,String> {
    List<Account> findByAccountNumber(String accountNumber);

    Account deleteByAccountNumber(String accountNumber);

    void deleteAllByAccountNumber(String accountNumber);
}
