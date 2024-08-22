package org.sta.crrs.car_rental_reservation_system.models.rentaloffice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sta.crrs.car_rental_reservation_system.models.car.Car;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Your branch location  is required")
    private String address1;
    private String address2;

    @NotNull
    private String city;

    @NotNull
    private String country;

//    @OneToMany
//    @JoinColumn(name="employee_id")
//    private List<Employee> employees;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="rental_id")
    private Rental rental;
    @JsonIgnore
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Car> cars;

    @JsonIgnore
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Employee> employees;

}