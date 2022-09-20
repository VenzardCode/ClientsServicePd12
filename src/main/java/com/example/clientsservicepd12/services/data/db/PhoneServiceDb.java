package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.Phone;
import com.example.clientsservicepd12.repositories.PhoneRepository;
import com.example.clientsservicepd12.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceDb implements PhoneService {
	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
	}

	@Override
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		phoneRepository.deleteById(id);
	}
}
