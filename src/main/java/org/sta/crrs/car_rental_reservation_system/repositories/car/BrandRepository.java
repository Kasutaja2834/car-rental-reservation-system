package org.sta.crrs.car_rental_reservation_system.repositories.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.car.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findBrandByName(String brandName);
}
