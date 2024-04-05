package com.example.SunBaseAssign.controller;
import com.example.SunBaseAssign.modal.Customer;
import com.example.SunBaseAssign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")//working
    public String addCustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/fetchAll")//working
    public List<Customer> getAllCustomer()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("/fetchById")//working
    public Customer fetchByCustomerId(Integer studentId) {
        return customerService.fetchByCustomerId(studentId);
    }


    @PutMapping("/update/{id}/{firstName}")//done
    public ResponseEntity updateUserFirstName(@PathVariable Integer id, @PathVariable String firstName){
        try{
            Customer student=customerService.updateCustomerFirstName(id,firstName);
            return new ResponseEntity(student, HttpStatus.FOUND);

        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete")
    public String deleteCustomer(Integer customerIds){
        String message=customerService.deleteCustomer(customerIds);
        return message;
    }

}
