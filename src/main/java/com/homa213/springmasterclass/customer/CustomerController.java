package com.homa213.springmasterclass.customer;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customre) {
        return customerService.createCustomer(customre);
    }

    @PutMapping(path = "{id}")
    public Customer updateCustomer(@RequestBody @Valid Customer customre, @PathVariable("id") Long id) {
        return customerService.updateCustomer(customre, id);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
     customerService.deleteCustomer(id);
    }

}
