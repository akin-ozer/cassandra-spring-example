package akin.cassexample.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface NameGetterService {
    String getFirstName(String name);
    Iterable findAll();
}
