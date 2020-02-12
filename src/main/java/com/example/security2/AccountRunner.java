package com.example.security2;

import com.example.security2.account.Account;
import com.example.security2.account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * AccountRunner
 */
@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account keesun = accountService.createAccount("keesun", "1234");
        System.out.println(keesun.getUsername() + " password: " + keesun.getPassword());
    }

}