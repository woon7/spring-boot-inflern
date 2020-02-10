package com.example.data5.account;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * AccountRepository
 */
public interface AccountRepository extends Neo4jRepository<Account, Long> {

}