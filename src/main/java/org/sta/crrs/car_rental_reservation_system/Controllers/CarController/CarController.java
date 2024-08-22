package org.sta.crrs.car_rental_reservation_system.Controllers.CarController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sta.crrs.car_rental_reservation_system.models.car.Car;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;
import org.sta.crrs.car_rental_reservation_system.services.car.CarServices;
import org.sta.crrs.car_rental_reservation_system.services.rentaloffice.branch.RentalBranchServices;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/branch")

public class CarController {
    private final CarServices carServices;
    private final RentalBranchServices branchServices;

    @Autowired
    public CarController(CarServices carServices, RentalBranchServices branchServices) {
        this.carServices = carServices;
        this.branchServices = branchServices;
    }


    @PostMapping("/{branchId}/car/add")
    public ResponseEntity<?> addCar(@RequestBody Car car, @PathVariable Long branchId) {

        if (branchServices.existRentalOfficeBranchById(branchId)) {
            Branch branch = branchServices.findBranchById(branchId);
            car.setBranch(branch);
            carServices.createCar(car);
            return ResponseEntity.ok(carServices.findAvailableCars());
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Rental Office  branch with ID " + branchId + " does not exist");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

//        carServices.createCar(car);
//        return ResponseEntity.ok(carServices.findAvailableCars());
    }


//    @GetMapping("/available")
//    public ResponseEntity<?> getAvailableCars() {
//        return ResponseEntity.ok(carServices.findAvailableCars());
//    }

    @GetMapping("/car")
    public ResponseEntity<?> getAllCars() {
        return ResponseEntity.ok(carServices.findAllCars());
    }

    @GetMapping("/car/{carID}")
    public ResponseEntity<?> getCar(@PathVariable("carID") Long carID) {
        if (carServices.existsCarById(carID))
            return ResponseEntity.ok(carServices.findCarById(carID));

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Car with ID " + carID + " does not exist");
        // Return the custom response with a 404 status
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
//@GetMapping("/search/param")
//public List<Car> gotCarListByParameter(@RequestParam String param) {
//    return this.gotCarListByParameter(param);
//}


//   // @Transactional
//    @PutMapping("{carID}/image")
////    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> changeCarImage(@PathVariable("carID") Long carID, @RequestBody MultipartFile file) throws IOException {
//        if (carService.existsById(carID)) {
//            carService.changeImage(carID, file);
//            return new ResponseEntity<>("Car photo changed", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
//    }

//    @PutMapping("{carID}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> editCar(@PathVariable("carID") Long carID, @RequestBody @Valid EditCarRequest carRequest) {
//        if (carService.existsById(carID)) {
//            carService.update(carID, carRequest);
//            return new ResponseEntity<>("Car information changed", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
//    }
//

//
//    @PutMapping("{carID}/status")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> changeCarStatus(@PathVariable("carID") Long carID) {
//        if (carService.existsById(carID)) {
//            Car car = carService.getCarById(carID);
//
//            if (!rentalService.existsDateAndStatus(LocalDate.now(), RentalStatusEnum.STATUS_ACCEPTED)) {
//                carService.changeStatus(car);
//                return new ResponseEntity<>("The availability of the car has been changed", HttpStatus.OK);
//            }
//
//            return new ResponseEntity<>("Car has active rental", HttpStatus.CONFLICT);
//        }
//
//        return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
//    }

//    @DeleteMapping("{carID}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> deleteCar(@PathVariable("carID") Long carID) {
//        if (carService.existsById(carID)) {
//            Car car = carService.getCarById(carID);
//
//            if (!rentalService.existsByCarId(car.getId())) {
//                carService.delete(car);
//                return new ResponseEntity<>("Car removed successfully", HttpStatus.OK);
//            }
//
//            return new ResponseEntity<>("You cannot remove a car if it has a rental assigned to it", HttpStatus.CONFLICT);
//        }
//
//        return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
//    }



