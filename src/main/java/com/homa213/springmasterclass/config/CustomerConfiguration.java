package com.homa213.springmasterclass.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    //it can be configured as
    // 1. a program argument in configuration setting
    // or as
    // 2. a key value in application.properties file
//    @Value("${app.customer.useFakeRepository}")
//    private boolean useFakeRepository;


    // it's used for performing functionalities at the start of a project
    //for example saving some data in db etc...
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("hi...");
        };
    }


    //it's  another option for creating Beans.
    // you can customize it and have your own conditions for it.
    //in this implementation you don't need to use @Component for those classes
//    @Bean
//    CustomerRepository getCustomerRepo() {
//        return useFakeRepository ? new CustomerFakeRepo() : new CustomerRepo();
//    }


}
