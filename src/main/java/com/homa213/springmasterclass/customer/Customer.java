package com.mahd312.springmasterclass.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Customer {
    //    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @JsonProperty("customerName")
    @NotBlank(message = "name should have a value")
    private String name;

    @Email(message = "email is not correct")
    private String email;

    @Min(value = 0 , message = "age must be more than Zero")
    @Max(value = 120, message = "age must be less than 120 years")
    private Integer age;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8 , message = "Password must be more than 8 characters")
    private String password;

    public Customer(Long id, String name, String email, Integer age, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

}
