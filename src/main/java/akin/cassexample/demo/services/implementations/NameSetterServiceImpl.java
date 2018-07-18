package akin.cassexample.demo.services.implementations;

import akin.cassexample.demo.domains.Customer;
import akin.cassexample.demo.repositories.CustomerRepository;
import akin.cassexample.demo.services.NameSetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NameSetterServiceImpl implements NameSetterService {

    private CustomerRepository customerRepository;

    @Autowired
    public NameSetterServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(UUID id, String name, String lastName) {
        Customer customer = new Customer(id, name, lastName);
        customerRepository.save(customer);
    }
}
