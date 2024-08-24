package org.sta.crrs.car_rental_reservation_system.controllers.RentalOfficeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Employee;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Rental;
import org.sta.crrs.car_rental_reservation_system.services.rentaloffice.branch.RentalBranchServices;
import org.sta.crrs.car_rental_reservation_system.services.rentaloffice.employee.EmployeeServices;
import org.sta.crrs.car_rental_reservation_system.services.rentaloffice.rentaloffice.RentalOfficeServices;
import org.sta.crrs.car_rental_reservation_system.utils.dataTransferDTO.BranchCreationDTO;
import org.sta.crrs.car_rental_reservation_system.utils.dataTransferDTO.EmployeeCreationDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rental")
public class RentalOfficeController {

    private final RentalOfficeServices rentalOfficeServices;
    private final RentalBranchServices rentalBranchServices;
    private final EmployeeServices employeeServices;

    @Autowired
    public RentalOfficeController(RentalOfficeServices rentalOfficeServices, RentalBranchServices rentalBranchServices, EmployeeServices employeeServices) {
        this.rentalOfficeServices = rentalOfficeServices;
        this.rentalBranchServices = rentalBranchServices;
        this.employeeServices = employeeServices;
    }

    @GetMapping()
    public ResponseEntity<?> getAllOffices() {
        return ResponseEntity.ok(rentalOfficeServices.findAllRentalOffices());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewRentalOffice(@RequestBody Rental rental) {
        rentalOfficeServices.createNewRentalOffice(rental);
        return ResponseEntity.ok(rentalOfficeServices.findAllRentalOffices());
    }

    @GetMapping("/branch")
    public ResponseEntity<?> getAllBranchesFull() {
        return ResponseEntity.ok(rentalBranchServices.findAllBranches());
    }

//    @GetMapping("/branch")
//    public ResponseEntity<?> getAllBranchesShort() {
//        return ResponseEntity.ok(rentalBranchServices.findAllBranchesShort());
//    }

    @GetMapping("/branch/employee")
    public ResponseEntity<?> getBrancheAllEmployee() {
        return ResponseEntity.ok(employeeServices.findAllEmployee());
    }

    @PostMapping("/branch/{branchId}/employee/add")
    public ResponseEntity<?> addBranchNewEmployee(@RequestBody Employee employee, @PathVariable Long branchId) {
        if (rentalBranchServices.existRentalOfficeBranchById(branchId)) {
            Branch branch = rentalBranchServices.findBranchById(branchId);
            employee.setBranch(branch);
            Employee createdEmployee = employeeServices.createEmployee(employee);
            EmployeeCreationDTO employeeCreationDTO = getEmployeeCreationDTO(createdEmployee, branch);
            return ResponseEntity.ok(employeeCreationDTO);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Rental Office  branch with ID " + branchId + " does not exist");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{rentalId}/branch/add")
    public ResponseEntity<?> addRentalOfficeNewBranch(@RequestBody Branch branch, @PathVariable Long rentalId) {
        if (rentalOfficeServices.existsRentalOfficeById(rentalId)) {
            Rental rental = rentalOfficeServices.findRentalOfficeById(rentalId);
            branch.setRental(rental);// Set the rental object in the branch
            Branch createdBranch = rentalBranchServices.createBranch(branch);
            BranchCreationDTO branchCreationDTO = getBranchCreationDTO(createdBranch, rental);
            return ResponseEntity.ok(branchCreationDTO);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Rental Office with ID " + rentalId + " does not exist");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    private static EmployeeCreationDTO getEmployeeCreationDTO(Employee createdEmployee, Branch branch) {
        EmployeeCreationDTO employeeCreationDTO = new EmployeeCreationDTO();
        employeeCreationDTO.setId(createdEmployee.getId());
        employeeCreationDTO.setFirstName(createdEmployee.getFirstName());
        employeeCreationDTO.setLastName(createdEmployee.getLastName());
        employeeCreationDTO.setRole(createdEmployee.getRole());
        employeeCreationDTO.setUsername(createdEmployee.getUsername());
        employeeCreationDTO.setEmail(createdEmployee.getEmail());
        employeeCreationDTO.setPosition(createdEmployee.getPosition());
        employeeCreationDTO.setBranch(branch);
        return employeeCreationDTO;
    }

    private static BranchCreationDTO getBranchCreationDTO(Branch createdBranch, Rental rental) {
        BranchCreationDTO branchCreationDTO = new BranchCreationDTO();
        branchCreationDTO.setId(createdBranch.getId());
        branchCreationDTO.setAddress1(createdBranch.getAddress1());
        branchCreationDTO.setAddress2(createdBranch.getAddress2());
        branchCreationDTO.setCity(createdBranch.getCity());
        branchCreationDTO.setCountry(createdBranch.getCountry());
        branchCreationDTO.setRental(rental);
        return branchCreationDTO;
    }

//    @Override
//    public String toString() {
//        return "Branch{id=" + br +
//                ", address1='" + address1 + '\'' +
//                ", city='" + city + '\'' +
//                ", country='" + country + '\'' +
//                '}';
//    }

}
//
//
//    @GetMapping("/{carID}")
//    public ResponseEntity<?> getCar(@PathVariable("carID") Long carID) {
//        if (carServices.existsById(carID)) return ResponseEntity.ok(carServices.findCarById(carID));
//
//        Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("message", "Car with ID " + carID + " does not exist");
//
//        // Return the custom response with a 404 status
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }


//    @PostMapping("/branch/add")
//    public ResponseEntity<?> addRentalOfficeNewBranch(@RequestBody Branch branch) {
//        rentalBranchServices.createBranch(branch);
//        return ResponseEntity.ok(rentalBranchServices.findAllBranches());
//    }

//    @PostMapping("/{rentalId}/branch/add")
//    public ResponseEntity<?> addRentalOfficeNewBranch(@RequestBody Branch branch, @PathVariable("rentalId") Long rentalId) {
//        if (rentalOfficeServices.existsRentalOfficeById(rentalId)) {
//            rentalBranchServices.createBranch(branch, rentalId);
//            return ResponseEntity.ok(rentalBranchServices.findAllBranchesByRentalOffice(rentalOfficeServices.findRentalOfficeById(rentalId)));
//        } else {
//            Map<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("message", "Rental Office  with ID " + rentalId + " does not exist");
//            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//            // Return the custom response with a 404 status
//
//        }
//    }
//}