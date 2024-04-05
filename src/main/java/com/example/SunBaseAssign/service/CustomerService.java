package com.example.SunBaseAssign.service;

import com.example.SunBaseAssign.Exceptions.CustomerNotFoundException;
import com.example.SunBaseAssign.modal.Customer;
import com.example.SunBaseAssign.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    public String addCustomer(Customer customer) {
        if(customerRepository.findByCustomerEmail(customer.getCustomerEmail())==null) {
            customerRepository.save(customer);
            return "Data added successfully";
        }
        else {
            return "Data already exists";
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> studentList = customerRepository.findAll();
        if (!studentList.isEmpty()) {
            return studentList;
        }
        else {
            return new ArrayList<>();
        }
    }

    public Customer fetchByCustomerId(Integer customerId) {
        Optional<Customer> optionalStudent = customerRepository.findById(customerId);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        else {
            return null;
        }
    }


    public Customer updateCustomerFirstName(Integer id, String firstName) {
        Customer customer =customerRepository.findById(id).get();
        if(customer==null){
            throw new CustomerNotFoundException("Invalid id");
        }
        customer.setFirstName(firstName);
        customerRepository.save(customer);
        return customer;
    }

    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "user deleted successfully";
    }
}



