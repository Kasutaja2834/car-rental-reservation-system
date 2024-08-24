package org.sta.crrs.car_rental_reservation_system.controllers.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sta.crrs.car_rental_reservation_system.models.reservation.Reservation;
import org.sta.crrs.car_rental_reservation_system.services.resrevation.ReservationServices;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    public final ReservationServices reservationServices;

    @Autowired
    public ReservationController(ReservationServices reservationServices) {
        this.reservationServices = reservationServices;
    }

    @GetMapping("")
    public List<Reservation> getAllReservationes() {
      return   reservationServices.findAllReservations();

    }
}
