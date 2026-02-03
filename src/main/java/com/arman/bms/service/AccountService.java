package com.arman.bms.service;

import java.util.List;

import com.arman.bms.entity.Account;
import com.arman.bms.entity.Transaction;

public interface AccountService {

    Account createAccount(Account account);
    Account deposit(String accountNumber, double amount);
    Account withdraw(String accountNumber, double amount);
    Account getAccountByNumber(String accountNumber);
    List<Transaction> getStatement(String accountNumber);
}
