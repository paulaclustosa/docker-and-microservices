package com.letscode.customer.services;

import com.letscode.customer.entities.Customer;
import com.letscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCustomerByPublicIdService {
  @Autowired
  CustomerRepository customerRepository;

  public String execute(UUID publicId) {
    Customer customerFound = customerRepository.findByPublicId(publicId);
    customerRepository.delete(customerFound);
    return "Customer successfully deleted!";
  }
}
