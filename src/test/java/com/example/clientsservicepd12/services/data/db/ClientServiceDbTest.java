package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.Account;
import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.models.Phone;
import com.example.clientsservicepd12.services.data.AccountService;
import com.example.clientsservicepd12.services.data.ClientService;
import com.example.clientsservicepd12.services.data.PhoneService;
import com.example.clientsservicepd12.services.data.qualifiers.AccountServiceQualifier;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.clientsservicepd12.models.Client.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ClientServiceDbTest {
	@Autowired
	ClientService clientService;
	@Autowired
	PhoneService phoneService;
	@AccountServiceQualifier
	@Autowired
	AccountService accountService;
	static Client client1;
	static Client client2;

	@Order(1)
	@Test
	void save() {
		client1 = new Client(0, "a", "a", "a",
			LocalDate.now(), FEMALE, "e111", null, null);
		client1 = clientService.save(client1);
	}

	@Order(2)
	@Test
	void findAllBySurnameAndNameAndPatronymic() {
		List<Client> list = clientService.findAllBySurnameAndNameAndPatronymic(
			client1.getSurname(), client1.getName(), client1.getPatronymic()
		);
		list.forEach(System.err::println);
		//1
		assertNotEquals(list.size(), 0);
		//2
		boolean match = list.stream().allMatch(client ->
			client.getSurname().equals(client1.getSurname()) &&
				client.getName().equals(client1.getName()) &&
				client.getPatronymic().equals(client1.getPatronymic())
		);
		assertTrue(match);
	}

	@Order(3)
	@Test
	void saveClientPhones() {
		client1 = new Client(0, "a", "a", "a",
			LocalDate.now(), FEMALE, "e111", null, null);
		client1 = clientService.save(client1);
		//
		Phone phone1 = new Phone(0L, "111", client1);
		Phone phone2 = new Phone(0L, "222", client1);
		phone1 = phoneService.save(phone1);
		phone2 = phoneService.save(phone2);
		//
		if (client1.getPhones() == null)
			client1.setPhones(new HashSet<>());
		//
		client1.getPhones().add(phone1);
		client1.getPhones().add(phone2);
		//
		client1 = clientService.save(client1);
		//
		System.err.println(client1.getPhones());
	}
}