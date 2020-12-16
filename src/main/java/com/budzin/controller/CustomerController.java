package com.budzin.controller;
import com.budzin.domain.Customer;
import com.budzin.dto.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<Customer> customers  = customerService.getAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname()
            );
            customerDtos.add(customerDto);
        }
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Integer id) {
        Customer customer = customerService.getById(id);
        if (customer != null) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname()
            );
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Customer newCustomer) {
        customerService.create(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerDto> update(@PathVariable Integer id,
                                              @RequestBody Customer customer) {
        Customer customer1 = customerService.getById(id);
        if (customer1 != null) {
            customerService.update(id, customer);
            CustomerDto customerDto = new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname()
            );
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (customerService.getById(id) != null) {
            customerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}