package org.sta.crrs.car_rental_reservation_system.models.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name = "bodyType_Id")
    private BodyType bodyType;

    @NotNull
    @Min(value = 1980, message ="To work for rent, the car must be a newer model")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private CarColor carColor;

    String carStateNumberPlate;

    @Min(value=1, message = "Mileage can't be less")
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String imagePath; // ex.: "items/car_images/toyota_corolla_2017.png"

    @NotNull
    private Double amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "branch_id")
    private Branch branch;


}
