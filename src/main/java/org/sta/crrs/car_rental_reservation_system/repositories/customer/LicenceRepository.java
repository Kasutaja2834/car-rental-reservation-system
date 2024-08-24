package org.sta.crrs.car_rental_reservation_system.repositories.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.customer.Categories;
import org.sta.crrs.car_rental_reservation_system.models.customer.Licence;

@Repository
public interface LicenceRepository extends JpaRepository<Licence, Long> {
    boolean existsByCategory(Categories category);
}
