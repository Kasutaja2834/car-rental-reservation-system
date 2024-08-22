package org.sta.crrs.car_rental_reservation_system.repositories.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.car.CarModel;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel,Long> {
    CarModel findCarModelByName(String modelName);
}
