package com.example.data4;

import java.util.Optional;

import com.example.data4.account.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

	Optional<Account> findByEmail(String email);

}
