package com.example.clientsservicepd12;

import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.HashSet;

import static com.example.clientsservicepd12.models.Client.*;
import static com.example.clientsservicepd12.models.Client.Gender.*;

@SpringBootApplication
public class ClientsServicePd12Application {
	public static void main(String[] args) {
		SpringApplication.run(ClientsServicePd12Application.class, args);
	}

	@Autowired
	private ClientRepository clientRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void applicationReady() {
		Client client = new Client(0, "a", "a","a",
			LocalDate.now(), FEMALE, "e111",null, null);
		client = clientRepository.save(client);
		System.err.println(client);
		client.setSurname("A");
		clientRepository.save(client);
		clientRepository.delete(client);
		System.err.println();
		clientRepository.findAll().forEach(System.err::println);
	}
}
