package com.lakmal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakmal.entity.Account;
import com.lakmal.entity.User;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findByUser(User user);
}
