package com.example.security2.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Account
 */
@Entity
@Data
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;
    
}