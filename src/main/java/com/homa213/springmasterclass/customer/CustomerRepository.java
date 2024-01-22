package com.homa213.springmasterclass.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //    Before extending of JpaRepository
    //    List<Customer> getAllCustomers();


}
