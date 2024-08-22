package org.sta.crrs.car_rental_reservation_system.repositories.rentaloffice.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Rental;
@Repository
public interface RentalOfficeRepository extends JpaRepository<Rental, Long> {
}
