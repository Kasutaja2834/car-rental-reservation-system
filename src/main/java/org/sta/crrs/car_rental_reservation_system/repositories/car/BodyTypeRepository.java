package org.sta.crrs.car_rental_reservation_system.repositories.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.car.BodyType;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
    BodyType findBodyTypeByName(String bodyTypeName);

}
