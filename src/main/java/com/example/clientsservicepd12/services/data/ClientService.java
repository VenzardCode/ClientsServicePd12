package com.example.clientsservicepd12.services.data;

import com.example.clientsservicepd12.models.Client;

import java.util.List;

public interface ClientService {
	Client save(Client client);

	Client findBiId(Integer id);

	void delete(Client client);

	List<Client> findAllBySurnameAndNameAndPatronymic(
		String surname, String name,String patronymic);

	List<Client> findAll();
}
