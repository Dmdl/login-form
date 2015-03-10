package com.lakmal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakmal.entity.Account;
import com.lakmal.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public void save(Account account) {
		accountRepository.save(account);
	}
}
