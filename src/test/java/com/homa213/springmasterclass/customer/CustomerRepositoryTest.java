package com.homa213.springmasterclass.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest(
        properties = {
                "spring.jpa.properties.javax.persistence.validation.mode=none"
        }
)
class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository underTest;

    @Test
    void itShouldSaveCustomer() {
        // Given
        Random random = new Random();
        Long id = random.nextLong();
        Customer customer = new Customer(id, "Homa", "homa@gmail.com", 31, "s131sasdad");

        // When
        underTest.save(customer);

        // Then
        Optional<Customer> optionalCustomer = underTest.findById(id);
        assertThat(optionalCustomer)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c.getId()).isEqualTo(id);
                    assertThat(c.getName()).isEqualTo("Homa");
                    assertThat(c.getEmail()).isEqualTo("homa@gmail.com");
                    assertThat(c.getAge()).isEqualTo(31);
                    assertThat(c.getPassword()).isEqualTo("s131sasdad");
                });
    }

    @Test
    void itShouldNotSaveCustomerWhenNameIsNull() {
        // Given
        Random random = new Random();
        Long id = random.nextLong();
        Customer customer = new Customer(id, "", "homa@gmail.com", 31, "s131sasdad");

        // When
        // Then
        assertThatThrownBy(() -> underTest.save(customer))
                .hasMessageContaining("not-null property references a null : Customer.name")
                .isInstanceOf(DataIntegrityViolationException.class);

    }

}