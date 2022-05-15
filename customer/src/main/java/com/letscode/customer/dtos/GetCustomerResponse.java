package com.letscode.customer.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class GetCustomerResponse {
  private String name;
  private String username;
  private String email;
  private UUID publicId;
}
