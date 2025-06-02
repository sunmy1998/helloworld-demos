package com.swy;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author: SMY
 * @time: 2025/6/2  23:25
 * @description:
 */

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);
}
