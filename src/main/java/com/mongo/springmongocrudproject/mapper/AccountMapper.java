package com.mongo.springmongocrudproject.mapper;

import com.mongo.springmongocrudproject.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    Account mapModelToEntity(com.mongo.springmongocrudproject.model.Account account);

   /* List<com.mongo.springmongocrudproject.model.Account> listEntityToModel(List<Account> accountEntity);

    com.mongo.springmongocrudproject.model.Account mapEntityToModel(Account byAccountNumber);*/
}
