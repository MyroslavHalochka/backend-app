package com.example.backendapp.controller;

import com.example.backendapp.entity.Customer;
import com.example.backendapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public void saveCustomer(@RequestBody Customer customer) {

        customerService.addCustomer(customer);

    }

    @GetMapping(path = "/getAllCustomer")
    public List<Customer> getAllCustomer() {

        return customerService.getAllCustomer();

    }

    @PutMapping(path = "/update")
    public void updateCustomer(@RequestBody Customer customer) {

        customerService.updateCustomers(customer);

    }

    @DeleteMapping(path = "/deletecustomer/{id}")
    public void deleteCustomer(@PathVariable(value = "id") int id) {

        customerService.deleteCustomer(id);

    }

}