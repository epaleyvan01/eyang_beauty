package com.eyangbeauty.webapp.repository;

import com.eyangbeauty.webapp.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
    Boolean existsByEmail(String email);
}
