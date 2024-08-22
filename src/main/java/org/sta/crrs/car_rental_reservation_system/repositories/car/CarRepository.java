package org.sta.crrs.car_rental_reservation_system.repositories.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.car.Car;
import org.sta.crrs.car_rental_reservation_system.models.car.Status;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByStatus( Status status);
}
