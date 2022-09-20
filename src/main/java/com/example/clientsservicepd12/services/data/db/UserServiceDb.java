package com.example.clientsservicepd12.services.data.db;

import com.example.clientsservicepd12.models.User;
import com.example.clientsservicepd12.repositories.UserRepository;
import com.example.clientsservicepd12.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDb implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
}
