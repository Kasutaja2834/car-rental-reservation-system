package org.sta.crrs.car_rental_reservation_system.models.security;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
//@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

}
