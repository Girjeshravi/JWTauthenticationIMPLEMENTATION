package com.example.SunBaseAssign.repository;

import com.example.SunBaseAssign.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByCustomerEmail(String customerEmail);
}
