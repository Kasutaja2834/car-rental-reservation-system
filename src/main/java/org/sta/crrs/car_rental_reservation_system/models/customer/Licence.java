package org.sta.crrs.car_rental_reservation_system.models.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Licence {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(columnDefinition = "boolean default false")
    private Boolean valid;
}
