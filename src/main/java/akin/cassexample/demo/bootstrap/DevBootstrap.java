package akin.cassexample.demo.bootstrap;

import akin.cassexample.demo.domains.Customer;
import akin.cassexample.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    CustomerRepository customerRepository;

    @Autowired
    public DevBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData(){
        UUID id = UUID.randomUUID();
        Customer akin = new Customer(id,"Akin","Ozer");
        customerRepository.save(akin);

    }
}