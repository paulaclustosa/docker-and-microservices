package com.letscode.customer.services;

import com.letscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAllCustomersService {
  @Autowired
  CustomerRepository customerRepository;

  public String execute() {
    customerRepository.deleteAll();
    return "All customers were successfully deleted!";
  }
}
