package com.example.backendapp.service.impl;

import com.example.backendapp.entity.Customer;
import com.example.backendapp.repository.CustomerRepository;
import com.example.backendapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customerSave) {

        Customer customer = new Customer(

                customerSave.getCustomername(),
                customerSave.getCustomeraddress(),
                customerSave.getMobile()

        );

        customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAllCustomer() {

        return customerRepository.findAll();

    }

    @Override
    public void updateCustomers(Customer customerUpdate) {

        if (customerRepository.existsById(customerUpdate.getCustomerid())) {

            Customer customer = customerRepository.getReferenceById(customerUpdate.getCustomerid());

            customer.setCustomername(customerUpdate.getCustomername());
            customer.setCustomeraddress(customerUpdate.getCustomeraddress());
            customer.setMobile(customerUpdate.getMobile());

            customerRepository.save(customer);

        } else {

            System.out.println("Customer doesn't exist");

        }

    }

    @Override
    public void deleteCustomer(int id) {

        if (customerRepository.existsById(id)) {

            customerRepository.deleteById(id);

        } else {

            System.out.println("Customer not found");

        }

    }

}