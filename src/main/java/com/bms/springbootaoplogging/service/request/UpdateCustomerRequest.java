package com.bms.springbootaoplogging.service.request;

public record UpdateCustomerRequest(
        String firstName,
        String lastName
) {
}
