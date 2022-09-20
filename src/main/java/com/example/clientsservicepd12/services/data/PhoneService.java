package com.example.clientsservicepd12.services.data;

import com.example.clientsservicepd12.models.Phone;

import java.util.List;

public interface PhoneService {
	Phone save(Phone phone);

	List<Phone> findAll();

	void deleteById(Long id);
}
