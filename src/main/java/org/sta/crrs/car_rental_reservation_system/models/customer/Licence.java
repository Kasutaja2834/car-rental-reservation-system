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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column( nullable = false, columnDefinition = "VARCHAR(20) default 'B_SOIDUAUTO'")//name="category",
   // @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(columnDefinition = "boolean default true")
    private Boolean valid;

//    @ManyToOne //many rights can have one customer
//    private Licence licence;
}
