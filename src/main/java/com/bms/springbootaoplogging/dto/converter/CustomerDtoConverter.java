package com.bms.springbootaoplogging.dto.converter;

import com.bms.springbootaoplogging.core.dto.DtoConverter;
import com.bms.springbootaoplogging.dto.CustomerDto;
import com.bms.springbootaoplogging.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter implements DtoConverter<CustomerDto, Customer> {
    public CustomerDto convert(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName()
        );
    }

}
