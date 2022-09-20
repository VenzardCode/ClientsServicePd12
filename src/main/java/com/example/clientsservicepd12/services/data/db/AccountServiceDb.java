package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.Account;
import com.example.clientsservicepd12.repositories.AccountRepository;
import com.example.clientsservicepd12.services.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDb implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}
}
