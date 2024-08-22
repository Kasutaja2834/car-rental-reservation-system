package org.sta.crrs.car_rental_reservation_system.repositories.rentaloffice.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
