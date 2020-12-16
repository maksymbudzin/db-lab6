package com.budzin.service;

import com.budzin.domain.Customer;
import com.budzin.domain.Feedback;
import com.budzin.domain.Rating;
import com.budzin.repository.CustomerRepository;
import com.budzin.repository.FeedbackRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements AbstractService<Customer, Integer> {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Integer id, Customer customer) {
        if (customerRepository.findById(id).isPresent()) {
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        }
    }
}