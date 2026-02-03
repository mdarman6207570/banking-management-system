package com.arman.bms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arman.bms.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	 Optional<Account> findByAccountNumber(String accountNumber);
}
