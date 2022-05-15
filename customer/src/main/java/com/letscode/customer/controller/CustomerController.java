package com.letscode.customer.controller;

import com.letscode.customer.dtos.*;
import com.letscode.customer.entities.Customer;
import com.letscode.customer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  CreateCustomerService createCustomerService;
  @Autowired
  GetCustomerByPublicIdService getCustomerByPublicIdService;
  @Autowired
  GetAllCustomersService getAllCustomersService;
  @Autowired
  DeleteAllCustomersService deleteAllCustomersService;
  @Autowired
  DeleteCustomerByPublicIdService deleteCustomerByPublicIdService;

  @PostMapping()
  public ResponseEntity<CreateCustomerResponse> createCustomer(
      @RequestBody CreateCustomerRequest request,
      UriComponentsBuilder uriComponentsBuilder
  ) {
    Customer customerCreated = createCustomerService.execute(request);
    URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(customerCreated.getPublicId()).toUri();
    return ResponseEntity.created(uri).body(CreateCustomerMapper.toCreateCustomerResponse(customerCreated));
  }

  @GetMapping("/{publicId}")
  public GetCustomerResponse getCustomerByPublicId(@PathVariable(value = "publicId") UUID id) {
    try {
      Customer customerFound = getCustomerByPublicIdService.execute(id);
      return GetCustomerMapper.toGetCustomerResponse(customerFound);
    } catch (Exception ex) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.", ex);
    }
  }

  @GetMapping()
  public List<GetCustomerResponse> getAllCustomers() {
    List<Customer> usersFound = getAllCustomersService.execute();
    return usersFound.stream().map(GetCustomerMapper::toGetCustomerResponse).toList();
  }

  @DeleteMapping()
  public String deleteAllCustomers() {
    return deleteAllCustomersService.execute();
  }

  @DeleteMapping("/{publicId}")
  public String deleteCustomerByPublicId(@PathVariable(value = "publicId") UUID id) {
    try {
      return deleteCustomerByPublicIdService.execute(id);
    } catch (Exception ex) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.", ex);
    }
  }

}
