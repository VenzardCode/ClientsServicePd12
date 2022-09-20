package com.example.clientsservicepd12.services.data;

import com.example.clientsservicepd12.models.Account;

import java.util.List;

public interface AccountService {
	List<Account> findAll();

	Account save(Account account);
}
