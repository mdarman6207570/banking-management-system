package com.arman.bms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arman.bms.entity.Customer;
import com.arman.bms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer login(String email, String password) {

        Optional<Customer> opt = customerRepository.findByEmail(email);

        if (opt.isPresent()) {
            Customer customer = opt.get();

            if (customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

}
