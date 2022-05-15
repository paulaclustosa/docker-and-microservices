package com.letscode.customer.dtos;

import com.letscode.customer.entities.Customer;

public class GetCustomerMapper {

  public static GetCustomerResponse toGetCustomerResponse(Customer user) {
    return GetCustomerResponse.builder()
        .name(user.getName())
        .username(user.getUsername())
        .email(user.getEmail())
        .publicId(user.getPublicId())
        .build();
  }
}
