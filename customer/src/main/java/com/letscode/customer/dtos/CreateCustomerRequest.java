package com.letscode.customer.dtos;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class CreateCustomerRequest {
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @NotEmpty
  private String username;
  @Email
  private String email;
  @Size(min=6, max=8)
  private String password;
}
