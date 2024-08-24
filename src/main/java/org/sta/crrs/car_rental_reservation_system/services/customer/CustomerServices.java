package org.sta.crrs.car_rental_reservation_system.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sta.crrs.car_rental_reservation_system.models.customer.Customer;
import org.sta.crrs.car_rental_reservation_system.repositories.customer.CustomerRepository;
import org.sta.crrs.car_rental_reservation_system.repositories.customer.LicenceRepository;
import org.sta.crrs.car_rental_reservation_system.repositories.security.RoleRepository;

import java.util.List;

@Service
public class CustomerServices {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final LicenceRepository licenceRepository;


//    public CustomerRepository getCustomerRepository() {
//        return customerRepository;
//    }

    @Autowired
    public CustomerServices(CustomerRepository customerRepository, RoleRepository roleRepository, LicenceRepository licenceRepository) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.licenceRepository = licenceRepository;
    }

    public Customer createCustomer(Customer customer) {
        // Check if role is set, if not, use default
//        if (customer.getRole() == null || customer.getRole().getId() == null || customer.getRole().getId() == 0) {
//            Role defaultRole = roleRepository.findRoleByName(Roles.ROLE_INCOGNITO); //.orElseThrow(() -> new RuntimeException("Default role not found"));
//            customer.setRole(defaultRole);
//        }
//        // Check if licence is set, if not, use default
//        if (customer.getLicence() == null || customer.getLicence().isEmpty())  {
//            Licence defaultLicence = new Licence();
//            defaultLicence.setCategory(Categories.B_SOIDUAUTO);
//            defaultLicence.setValid(true);
//            customer.setLicence(List.of(defaultLicence));
//        }
     //   System.out.println(customer);
        return this.customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer findCustomerById(Long customerId) {
        return this.customerRepository.findById(customerId).get();//isPresent
    }

    public Boolean existsCustomerById(Long customerId) {
        return this.customerRepository.existsById(customerId);
    }

    public Customer updateCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        this.customerRepository.deleteById(customerId);
    }


}
