package org.sta.crrs.car_rental_reservation_system.repositories.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.reservation.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
