package org.sta.crrs.car_rental_reservation_system.repositories.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sta.crrs.car_rental_reservation_system.models.car.CarColor;

public interface ColorRepository extends JpaRepository<CarColor, Long> {
    CarColor findCarColorByName(String colorName);
}
