package akin.cassexample.demo.repositories;

import java.util.List;
import java.util.UUID;

import akin.cassexample.demo.domains.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CassandraRepository<Customer, UUID> {

    @Query("Select * from customer where firstname=?0")
    Customer findByFirstName(String firstName);

    @Query("Select * from customer where lastname=?0")
    List<Customer> findByLastName(String lastName);

}