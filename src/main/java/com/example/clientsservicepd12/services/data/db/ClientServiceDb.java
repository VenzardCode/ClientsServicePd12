package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.repositories.ClientRepository;
import com.example.clientsservicepd12.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceDb implements ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client findBiId(Integer id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public List<Client> findAllBySurnameAndNameAndPatronymic(
		String surname, String name, String patronymic) {
		return clientRepository.findAllBySurnameAndNameAndPatronymic(
			surname, name, patronymic);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
}
