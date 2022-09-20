package com.example.clientsservicepd12.repositories;

import com.example.clientsservicepd12.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
