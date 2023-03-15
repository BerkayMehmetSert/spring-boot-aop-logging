package com.bms.springbootaoplogging.repository;

import com.bms.springbootaoplogging.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByFirstNameIgnoreCase(String firstName);

    boolean existsByLastNameIgnoreCase(String lastName);
}