package com.mongo.springmongocrudproject.controller;

import com.mongo.springmongocrudproject.model.Account;
import com.mongo.springmongocrudproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/saveAccount")
    public ResponseEntity<String> saveAccountDetails(@RequestBody Account account){
        if(Objects.nonNull(account)){
            String message = accountService.saveAccountDetails(account);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Input request Invalid please provide proper request",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllAccount")
    public ResponseEntity<List<Account>> getAllAccountDetails(){
        return new ResponseEntity<>(accountService.getAllAccountDetails(),HttpStatus.OK);
    }

    @GetMapping("/getAccountByAccountNumber")
    public ResponseEntity<Account> getAccountDetailsByAccountNum(@RequestParam("accountNumber")String accountNumber){
        return new ResponseEntity<>(accountService.getAccountByAccountNumber(accountNumber),HttpStatus.OK);
    }
}
