package com.arman.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.arman.bms.entity.Customer;
import com.arman.bms.service.ICustomerService;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.registerCustomer(customer);
        return "success";
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        Customer customer = customerService.login(email, password);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }

}
