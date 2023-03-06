package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
//    Create, Update, Delete, GetByID, Get By State

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = customerRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @DeleteMapping("customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/customers/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return customerRepository.findAllCustomersByState(state);
    }
}
