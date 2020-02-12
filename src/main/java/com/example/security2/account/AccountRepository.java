package com.example.security2.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccountRepository
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByUsername(String username);
    
}