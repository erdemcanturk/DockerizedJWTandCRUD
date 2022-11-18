package com.erdem.dockerizedcrud.service;


import com.erdem.dockerizedcrud.model.Customer;
import com.google.gson.JsonElement;


import java.util.List;
import java.util.Optional;


public interface ICustomerService  {


    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);


   // List<Customer> findAllCustomer(Long id);

    List<JsonElement> findAllCustomer();

    Optional<Customer> findById(Long id);
}
