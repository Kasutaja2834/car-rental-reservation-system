package org.sta.crrs.car_rental_reservation_system.services.rentaloffice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Employee;
import org.sta.crrs.car_rental_reservation_system.repositories.rentaloffice.employee.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findById(id).get(); //isPresent check ??
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }


}




