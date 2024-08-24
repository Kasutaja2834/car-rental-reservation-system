package org.sta.crrs.car_rental_reservation_system.controllers.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sta.crrs.car_rental_reservation_system.models.customer.Customer;
import org.sta.crrs.car_rental_reservation_system.services.customer.CustomerServices;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerServices customerServices;
    //private final RentalBranchServices branchServices;

    @Autowired
    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerServices.findAllCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
       // Customer createCustomer = customerServices.createCustomer(customer);
         customerServices.createCustomer(customer);
       // return new ResponseEntity<>(createCustomer, HttpStatus.CREATED);
        return ResponseEntity.ok().build();
    }

}
