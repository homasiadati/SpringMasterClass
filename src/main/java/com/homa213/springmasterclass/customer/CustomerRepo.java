package com.mahd312.springmasterclass.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//We manage the Bean in CustomerConfiguration class

//@Component(value = "CustomerRepo")
// or   @Repository(value = "CustomerRepo")
//@Primary when there is no qualifier it will be the primary usage of bean
public abstract class CustomerRepo implements CustomerRepository{
//    @Override
//    public List<Customer> getAllCustomers() {
//        return Collections.emptyList();
//    }
}
