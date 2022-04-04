package com.pwojcik.instastatisticweb.controller;

import com.pwojcik.instastatisticweb.model.InstaAccount;
import com.pwojcik.instastatisticweb.service.AccountsRepositoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/api/accounts")
public class AccountsController {

    private final AccountsRepositoryService accountsRepositoryService;

    public AccountsController(AccountsRepositoryService accountsRepositoryService) {
        this.accountsRepositoryService = accountsRepositoryService;
    }

    @GetMapping
    public String getAccounts(Model model) {
        List<InstaAccount> accounts = accountsRepositoryService.getAccounts();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @GetMapping("/{accountName}")
    public String getAccount(@PathVariable String accountName, Model model) {
        InstaAccount account = accountsRepositoryService.getAccount(accountName);
        model.addAttribute("account", account);
        return "account";
    }

    @GetMapping("/add-account")
    public String addAccount(Model model) {
        model.addAttribute("newAccount", new InstaAccount());
        return "add-account";
    }

    @PostMapping("/add-account")
    public RedirectView postAccount(@ModelAttribute InstaAccount instaAccount) {
        accountsRepositoryService.addAccount(instaAccount);
        return new RedirectView("/api/accounts");
    }

}
