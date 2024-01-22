package com.homa213.springmasterclass.customer;

import java.util.Arrays;
import java.util.List;

//We manage the Bean in CustomerConfiguration class
//@Component(value = "CustomerFakeRepo")
public class CustomerFakeRepo {

    public List<Customer> getAllCustomers() {
        return Arrays.asList(
                new Customer(1L, "Homa1", "email@gmail.com", 16, "sdfds3421"),
                new Customer(2L, "Homa2", "email@gmail.com", 31, "2342343sf4")
        );
    }
}
