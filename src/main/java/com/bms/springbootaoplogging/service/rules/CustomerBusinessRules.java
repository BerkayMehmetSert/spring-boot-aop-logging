package com.bms.springbootaoplogging.service.rules;

import com.bms.springbootaoplogging.core.exceptions.NotFoundException;
import com.bms.springbootaoplogging.model.Customer;
import com.bms.springbootaoplogging.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;

    public CustomerBusinessRules(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void checkIfCustomerExistsByFirstName(String firstName) {
        if (customerRepository.existsByFirstNameIgnoreCase(firstName)) {
            throw new NotFoundException("Customer with first name " + firstName + " already exists");
        }
    }

    public void checkIfCustomerExistsByLastName(String lastName) {
        if (customerRepository.existsByLastNameIgnoreCase(lastName)) {
            throw new NotFoundException("Customer with last name " + lastName + " already exists");
        }
    }

    public void checkIfCustomerListIsEmpty(List<Customer> customers) {
        if (customers.isEmpty()) {
            throw new NotFoundException("Customer list is empty");
        }
    }
}
