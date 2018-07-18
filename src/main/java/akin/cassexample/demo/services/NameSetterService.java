package akin.cassexample.demo.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface NameSetterService {
    void addCustomer(UUID id, String name, String lastName);
}

