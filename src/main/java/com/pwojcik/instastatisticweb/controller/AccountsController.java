package com.pwojcik.instastatisticweb.controller;

import com.pwojcik.instastatisticweb.model.InstaAccount;
import com.pwojcik.instastatisticweb.repository.AccountsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/accounts")
public class AccountsController {

    private final AccountsRepository accountsRepository;

    public AccountsController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @GetMapping
    public String getAccounts(Model model) {
        List<InstaAccount> accounts = new ArrayList<>(accountsRepository.getRepository().values());
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @GetMapping("/{accountName}")
    public String getAccount(@PathVariable String accountName, Model model) {
        InstaAccount account = accountsRepository.getAccount(accountName);
        model.addAttribute("account", account);
        return "account";
    }

}
