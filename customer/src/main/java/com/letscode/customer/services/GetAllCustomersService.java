package com.letscode.customer.services;

import com.letscode.customer.entities.Customer;
import com.letscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCustomersService {
  @Autowired
  CustomerRepository customerRepository;

  public List<Customer> execute() {
    return customerRepository.findAll();
  }
}
