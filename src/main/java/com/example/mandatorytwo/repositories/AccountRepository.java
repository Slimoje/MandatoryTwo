package com.example.mandatorytwo.repositories;

import com.example.mandatorytwo.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneByUsername(String username);
}
