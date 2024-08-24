package org.sta.crrs.car_rental_reservation_system.services.resrevation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sta.crrs.car_rental_reservation_system.models.reservation.Reservation;
import org.sta.crrs.car_rental_reservation_system.repositories.reservation.ReservationRepository;

import java.util.List;

@Service
public class ReservationServices {
    public final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServices(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        return this.reservationRepository.findAll();
    }


}
