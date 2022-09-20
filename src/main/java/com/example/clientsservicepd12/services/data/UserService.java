package com.example.clientsservicepd12.services.data;

import com.example.clientsservicepd12.models.User;

import java.util.List;

public interface UserService {
	User findByUsername(String username);

	List<User> findAll();

	User save(User user);
}
