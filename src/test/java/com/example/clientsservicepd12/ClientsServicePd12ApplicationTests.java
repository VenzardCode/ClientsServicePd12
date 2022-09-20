package com.example.clientsservicepd12;

import com.example.clientsservicepd12.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientsServicePd12ApplicationTests {
	@Autowired
	ClientRepository clientRepository;

	@Test
	void contextLoads() {
		//clientRepository=null;
		Assertions.assertNotNull(clientRepository,"Is NULL");
	}
}
