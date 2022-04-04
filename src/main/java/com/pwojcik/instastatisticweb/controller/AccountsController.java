package com.pwojcik.instastatisticweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/accounts")
public class AccountsController {


    @GetMapping("/{id}")
    public String getAccount(@PathVariable Long id) {
        return "index";
    }

}
