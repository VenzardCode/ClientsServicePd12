package com.example.clientsservicepd12.repositories;

import com.example.clientsservicepd12.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}