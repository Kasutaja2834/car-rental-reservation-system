package org.sta.crrs.car_rental_reservation_system.repositories.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
