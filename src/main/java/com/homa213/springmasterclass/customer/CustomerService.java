package com.mahd312.springmasterclass.customer;

import com.mahd312.springmasterclass.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    //todo without Dependency Injection
//    private CustomerRepository customerRepository;
//    public CustomerService() {
//        CustomerRepository customerRepository = new CustomerFakeRepo();
//    }

    //todo with Dependency Injection
    private final CustomerRepository customerRepository;

    //if there was no qualifier spring will look for @Primary in children of CustomerRepository
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException("customer with id:" + id + " not found");
                            LOGGER.error("customer with id:{} not found", id, notFoundException);
                            return notFoundException;
                        }
                );
    }

    Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        LOGGER.info("customer created");
        return savedCustomer;
    }

    Customer updateCustomer(Customer customer, Long id) {
        Customer currentCustomer = getCustomer(id);

        if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
            currentCustomer.setName(customer.getName());
        }
        if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
            currentCustomer.setEmail(customer.getEmail());
        }
        if (Objects.nonNull(customer.getPassword()) && !"".equalsIgnoreCase(customer.getPassword())) {
            currentCustomer.setPassword(customer.getPassword());
        }
        if (Objects.nonNull(customer.getAge())) {
            currentCustomer.setAge(customer.getAge());
        }
        return customerRepository.save(currentCustomer);
    }

    void deleteCustomer(Long id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
        LOGGER.warn("customer with id:{} deleted", id);
    }
}
