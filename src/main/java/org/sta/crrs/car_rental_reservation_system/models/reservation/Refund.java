package org.sta.crrs.car_rental_reservation_system.models.reservation;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Employee;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Refund {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne
        private Employee employee;

        @OneToOne
        private Reservation reservation;

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfReturn;


        private Double surcharge;

        @Max(value = 250, message = "No more than 250 characters")
        private String comments;
}


