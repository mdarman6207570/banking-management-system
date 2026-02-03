package com.arman.bms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arman.bms.entity.Account;
import com.arman.bms.entity.Transaction;
import com.arman.bms.repository.AccountRepository;
import com.arman.bms.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepo;

    @Override
    public Account createAccount(Account account) {
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    private String generateAccountNumber() {
        return "AC" + UUID.randomUUID().toString().substring(0, 8);
    }

   
    @Override
    public Account deposit(String accountNumber, double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

       
        Transaction txn = new Transaction();
        txn.setAccountNumber(accountNumber);
        txn.setTxnType("DEPOSIT");
        txn.setAmount(amount);
        txn.setBalanceAfter(account.getBalance());
        txn.setTxnTime(LocalDateTime.now());

        transactionRepo.save(txn);

        return account;
    }

   
    @Override
    public Account withdraw(String accountNumber, double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        
        Transaction txn = new Transaction();
        txn.setAccountNumber(accountNumber);
        txn.setTxnType("WITHDRAW");
        txn.setAmount(amount);
        txn.setBalanceAfter(account.getBalance());
        txn.setTxnTime(LocalDateTime.now());

        transactionRepo.save(txn);

        return account;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    
    @Override
    public List<Transaction> getStatement(String accountNumber) {
        return transactionRepo
                .findByAccountNumberOrderByTxnTimeDesc(accountNumber);
    }
}
