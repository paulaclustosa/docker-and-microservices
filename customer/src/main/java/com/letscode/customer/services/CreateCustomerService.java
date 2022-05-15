package com.letscode.customer.services;

import com.letscode.customer.dtos.CreateCustomerMapper;
import com.letscode.customer.dtos.CreateCustomerRequest;
import com.letscode.customer.entities.Customer;
import com.letscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {
  @Autowired
  CustomerRepository customerRepository;

  public Customer execute(CreateCustomerRequest request) {
    return customerRepository.save(CreateCustomerMapper.toCustomer(request));
  }

}
