package com.example.clientsservicepd12.repositories;

import com.example.clientsservicepd12.models.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.example.clientsservicepd12.models.Client.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ClientRepositoryTest {
	@Autowired
	ClientRepository clientRepository;
	static Client client1;
	static Client client2;

	@Order(1)
	@Test
	void insertTest() {
		client1 = new Client(0, "a", "a", "a",
			LocalDate.now(), FEMALE, "e111", null, null );
		client1 = clientRepository.save(client1);
	}

	@Order(2)
	@Test
	void readTest() {
		client2 = clientRepository.findById(client1.getId()).get();
		assertEquals(client1, client2);
	}

	@Order(3)
	@Test
	void updateTest() {
		client1.setSurname("AA");
		client2 = clientRepository.save(client1);
		assertEquals(client1.getSurname(), client2.getSurname());
	}

	@Order(4)
	@Test
	void deleteTest() {
		clientRepository.delete(client1);
		client2 = clientRepository.findById(client1.getId()).orElse(null);
		assertNull(client2);
	}
}
