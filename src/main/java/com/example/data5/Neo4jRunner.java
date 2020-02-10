package com.example.data5;

import com.example.data5.account.Account;
import com.example.data5.account.AccountRepository;
import com.example.data5.account.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Neo4jRunner
 */
@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setEmail("aaaa@email.com");
        account.setUsername("aaaa");

        Role role = new Role();
        role.setName("user");

        account.getRoles().add(role);

        accountRepository.save(account);
        
        System.out.println("finished");
    }

}