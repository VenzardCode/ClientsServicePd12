package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.Account;
import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.services.data.AccountService;
import com.example.clientsservicepd12.services.data.ClientService;
import com.example.clientsservicepd12.services.data.qualifiers.AccountServiceQualifier;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;

import static com.example.clientsservicepd12.models.Client.Gender.FEMALE;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsAccountsDbTest {
	@Autowired
	private ClientService clientService;
	@AccountServiceQualifier
	@Autowired
	private AccountService accountService;
	private static Client client1;
	private static Client client2;

	@Order(1)
	@Test
	void saveClientsAccounts() {
		client1 = new Client(0, "a", "a", "a",
			LocalDate.now(), FEMALE, "e111", null, null);
		client2 = new Client(0, "b", "a", "a",
			LocalDate.now(), FEMALE, "e222", null, null);
		Account account1 = new Account(0L, 100, null);
		Account account2 = new Account(0L, 200, null);
		//
		account1 = accountService.save(account1);
		account2 = accountService.save(account2);
		//
		client1.setAccounts(Set.of(account1, account2));
		client2.setAccounts(Set.of(account1, account2));
		//
		client1 = clientService.save(client1);
		client2 = clientService.save(client2);
		//
		System.err.println(client1.getAccounts());
		System.err.println(client2.getAccounts());
		//
		System.err.println(clientService.findBiId(2).getAccounts());
	}
}
