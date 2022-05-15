package com.letscode.customer.services;

import com.letscode.customer.entities.Customer;
import com.letscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCustomerByPublicIdService {
  @Autowired
  CustomerRepository customerRepository;

  public Customer execute(UUID publicId) {
    return customerRepository.findByPublicId(publicId);
  }
}
