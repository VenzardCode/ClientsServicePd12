package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.Account;
import com.example.clientsservicepd12.services.data.AccountService;
import com.example.clientsservicepd12.services.data.qualifiers.AccountServiceQualifier;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class AccountServiceDbTest {
	//@Qualifier("accountServiceDb")
	//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@AccountServiceQualifier
	@Autowired
	AccountService accountService;
	static Account account1;
	static Account account2;

	@Order(1)
	@Test
	void insertTest() {
		account1 = new Account(0L, 100, null);
		account2 = accountService.save(account1);
		assertNotNull(account2);
	}
}