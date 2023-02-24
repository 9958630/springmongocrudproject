package com.mongo.springmongocrudproject.DAO;

import com.mongo.springmongocrudproject.entity.Account;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AccountDAO extends MongoRepository<Account,String> {
    List<Account> findByAccountNumber(String accountNumber);

    List<Account> findByAccountNumberAndAmount(String accountNumber,Integer amount);     //

    Account deleteByAccountNumber(String accountNumber);

    void deleteAllByAccountNumber(String accountNumber);

    @Query(value = "{$and:[{accountNumber:{$eq:'23456709'}},{createTs:{$gt:?0}}]}")                                                    //  @Query(value = "{ $and: [{orderNo: { $in: ?0 } }]}")  //    @Query(value = "{$and:[{accountNumber:{$eq:'23456709'}},{createTs:{$gt:?0}}]}")
    List<Account> getDateFilter(Date createTs);



}
