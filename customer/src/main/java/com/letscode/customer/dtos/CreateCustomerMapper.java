package com.letscode.customer.dtos;

import com.letscode.customer.entities.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateCustomerMapper {

  public static Customer toCustomer (CreateCustomerRequest request) {
    return Customer.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .username(request.getUsername())
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
  }

  public static CreateCustomerResponse toCreateCustomerResponse (Customer customer) {
    return CreateCustomerResponse.builder()
        .publicId(customer.getPublicId())
        .email(customer.getEmail())
        .build();
  }
}
