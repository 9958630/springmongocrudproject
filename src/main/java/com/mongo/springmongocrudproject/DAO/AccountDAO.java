package com.mongo.springmongocrudproject.DAO;

import com.mongo.springmongocrudproject.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends MongoRepository<Account,String> {
    Account findByAccountNumber(String accountNumber);
}
