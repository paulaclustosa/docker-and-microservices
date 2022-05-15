package com.letscode.customer.repository;

import com.letscode.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  Customer findByPublicId(UUID publicId);
}
