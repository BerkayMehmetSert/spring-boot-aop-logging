package com.bms.springbootaoplogging.service;

import com.bms.springbootaoplogging.core.exceptions.NotFoundException;
import com.bms.springbootaoplogging.core.utilities.services.rules.BusinessRules;
import com.bms.springbootaoplogging.dto.CustomerDto;
import com.bms.springbootaoplogging.dto.converter.CustomerDtoConverter;
import com.bms.springbootaoplogging.model.Customer;
import com.bms.springbootaoplogging.repository.CustomerRepository;
import com.bms.springbootaoplogging.service.request.CreateCustomerRequest;
import com.bms.springbootaoplogging.service.request.UpdateCustomerRequest;
import com.bms.springbootaoplogging.service.rules.CustomerBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;
    private final CustomerBusinessRules rules;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerDtoConverter converter, CustomerBusinessRules rules) {
        this.customerRepository = customerRepository;
        this.converter = converter;
        this.rules = rules;
    }

    public void createCustomer(final CreateCustomerRequest request) {
        BusinessRules.run(() -> {
            rules.checkIfCustomerExistsByFirstName(request.firstName());
            rules.checkIfCustomerExistsByLastName(request.lastName());
        });

        var customer = new Customer(
                request.id(),
                request.firstName(),
                request.lastName()
        );

        customerRepository.save(customer);
    }

    public void updateCustomer(final int id, final UpdateCustomerRequest request) {
        var customer = getCustomer(id);

        var updatedCustomer = new Customer(
                customer.getId(),
                request.firstName(),
                request.lastName()
        );

        customerRepository.save(updatedCustomer);
    }

    public void deleteCustomer(final int id) {
        customerRepository.delete(getCustomer(id));
    }

    public CustomerDto getCustomerById(final int id) {
        return converter.convert(getCustomer(id));
    }

    public List<CustomerDto> getAllCustomers() {
        var customers = customerRepository.findAll();

        BusinessRules.run(() -> rules.checkIfCustomerListIsEmpty(customers));

        return converter.convert(customers);
    }

    private Customer getCustomer(final int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
