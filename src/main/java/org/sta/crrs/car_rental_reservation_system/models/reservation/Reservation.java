package org.sta.crrs.car_rental_reservation_system.models.reservation;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.sta.crrs.car_rental_reservation_system.models.car.Car;
import org.sta.crrs.car_rental_reservation_system.models.customer.Customer;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    @Column(nullable = false, updatable = false)
    private LocalDateTime dateOfBooking;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")//(name = "car_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CAR_RESERVATION"))
    private Car car;

    @ManyToOne
    @JoinColumn(name = "branchOfLoan_id")
    private Branch branchOfLoan;

    @ManyToOne
    @JoinColumn(name = "branchOfReturn_id")
    private Branch branchOfReturn; //return department

    @NotNull()
    private Double amount;


}
