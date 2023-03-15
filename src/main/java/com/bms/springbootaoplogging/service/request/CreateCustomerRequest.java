package com.bms.springbootaoplogging.service.request;

public record CreateCustomerRequest(
        Integer id,
        String firstName,
        String lastName
) {
}
