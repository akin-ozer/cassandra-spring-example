package akin.cassexample.demo.services.implementations;

import akin.cassexample.demo.repositories.CustomerRepository;
import akin.cassexample.demo.services.NameGetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameGetterServiceImpl implements NameGetterService {

    private CustomerRepository customerRepository;

    public String getFirstName(String name) {
            if (customerRepository.findByFirstName(name).getFirstName().equals(name)) {
                return customerRepository.findByFirstName(name).getFirstName();
            }
        return "yok öyle bisi";

    }

    public Iterable findAll(){
        return customerRepository.findAll();
    }

    @Autowired
    public NameGetterServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
