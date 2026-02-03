package com.arman.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arman.bms.entity.Account;
import com.arman.bms.entity.Transaction;
import com.arman.bms.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/create")
    public String showAccountForm(Model model) {
        model.addAttribute("account", new Account());
        return "create-account";
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute Account account, Model model) {
        Account saved = service.createAccount(account);
        model.addAttribute("msg", "Account Created Successfully");
        model.addAttribute("account", saved);
        return "account-success";
    }
    
    @GetMapping("/deposit")
    public String showDepositForm() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String depositMoney(
            @RequestParam String accountNumber,
            @RequestParam double amount,
           RedirectAttributes ra) {

        Account account = service.deposit(accountNumber, amount);

        ra.addFlashAttribute("accountNumber", account.getAccountNumber());
        ra.addFlashAttribute("amount", account.getBalance());
        return "redirect:/account/deposit/success";
    }
    
    @GetMapping("/deposit/success")
    public String depositSuccess() {
        return "deposit-success";
    }
    
    @GetMapping("/withdraw")
    public String showWithdrawForm() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawMoney(
            @RequestParam String accountNumber,
            @RequestParam double amount,
            RedirectAttributes ra) {

        service.withdraw(accountNumber, amount);

        ra.addFlashAttribute("accountNumber", accountNumber);
        ra.addFlashAttribute("amount", amount);

        return "redirect:/account/withdraw/success";
    }

    @GetMapping("/withdraw/success")
    public String withdrawSuccess() {
        return "withdraw-success";
    }

    @GetMapping("/balance")
    public String showBalanceForm() {
        return "check-balance";
    }

    @PostMapping("/balance")
    public String checkBalance(
            @RequestParam String accountNumber,
            Model model) {

        Account account = service.getAccountByNumber(accountNumber);

        model.addAttribute("account", account);
        return "balance-result";
    }
    
    @GetMapping("/statement")
    public String showStatementForm() {
        return "statement";
    }

    @PostMapping("/statement")
    public String viewStatement(
            @RequestParam String accountNumber,
            Model model) {

        List<Transaction> list = service.getStatement(accountNumber);
        model.addAttribute("transactions", list);

        return "statement-result";
    }

}
