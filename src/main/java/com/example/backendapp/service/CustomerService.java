package com.example.backendapp.service;

import com.example.backendapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customerSave);

    List<Customer> getAllCustomer();

    void updateCustomers(Customer customerUpdate);

    void deleteCustomer(int id);

}
