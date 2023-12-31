package com.vs.Customer.controller;

import com.vs.Customer.Services.CustomerService;
import com.vs.Customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        customerService.create(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/customer")
    public ResponseEntity<List<Customer>> read() {
        final List<Customer> customers = customerService.readAll();

        return customers != null &&  !customers.isEmpty()
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Customer> read(@PathVariable(name = "id") int id) {
        final Customer customer = customerService.read(id);

        return customer != null
                ? new ResponseEntity<>(customer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Customer customer) {
        final boolean updated = customerService.update(customer, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = customerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}