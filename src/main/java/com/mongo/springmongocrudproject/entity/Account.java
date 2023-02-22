package com.mongo.springmongocrudproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "account")
public class Account {

    @Id
    private String id;
    private String accountNumber;
    private String accountName;
    private Date createTs;
    private String accountType;
    private Integer amount;
    private Integer bankAmount;
    private String bankAddr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(Integer bankAmount) {
        this.bankAmount = bankAmount;
    }

    public String getBankAddr() {
        return bankAddr;
    }

    public void setBankAddr(String bankAddr) {
        this.bankAddr = bankAddr;
    }
}
