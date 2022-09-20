package com.example.clientsservicepd12.repositories;

import com.example.clientsservicepd12.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
