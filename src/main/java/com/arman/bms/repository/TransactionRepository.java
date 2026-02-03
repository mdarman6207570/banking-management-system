package com.arman.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arman.bms.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountNumberOrderByTxnTimeDesc(String accountNumber);
}
