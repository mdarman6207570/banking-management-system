package com.arman.bms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arman.bms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);

}
