package com.arman.bms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ACCOUNT_TRANSACTION")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnId;

    private String accountNumber;

    private String txnType; 

    private double amount;

    private double balanceAfter;

    private LocalDateTime txnTime;
}
