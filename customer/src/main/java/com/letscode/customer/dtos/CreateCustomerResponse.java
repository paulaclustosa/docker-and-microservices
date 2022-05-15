package com.letscode.customer.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateCustomerResponse {
  private UUID publicId;
  private String email;
  private String message;

  @Builder
  public CreateCustomerResponse(UUID publicId, String email) {
    this.publicId = publicId;
    this.email = email;
    this.message = "User successfully created!";
  }
}
