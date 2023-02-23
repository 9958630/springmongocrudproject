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
    public ResponseEntity<Object> getAccountDetailsByAccountNum(@RequestParam("accountNumber")String accountNumber){
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        if(Objects.nonNull(account))
        return new ResponseEntity<Object>(accountService.getAccountByAccountNumber(accountNumber),HttpStatus.OK);
        else
            return new ResponseEntity<>("Data not found or duplication are found",HttpStatus.BAD_REQUEST);

    }

    @PatchMapping("/updateAccount")
    public ResponseEntity<String> updateAccount(@RequestBody Account account){
        if(Objects.nonNull(account)){
            String message = accountService.updateAccount(account);
            if(message.contains("Updated successfully")) {
                return new ResponseEntity<>(accountService.updateAccount(account),HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity <>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<String> deleteAccount(@RequestParam("accountNumber") String accountNumber){
        String message = accountService.deleteAccount(accountNumber);
        if(message.equalsIgnoreCase("AccountNumber deleted successfully")){
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);

    }


}
