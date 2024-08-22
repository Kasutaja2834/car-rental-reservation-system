package org.sta.crrs.car_rental_reservation_system.models.rentaloffice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Lending Departments
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Company name  is required")
    private String name;

    @NotBlank(message = "Your webpages  is required")
    private String domain;

    @NotBlank(message = "Your location  is required")
    private String address1;

    private String address2;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotBlank(message = "Owner name is required")
    private String owner;

    //A logotype (also called wordmark) is a logo that uses only the brand's name
    @NotBlank(message = "Your logotype image  is required")
    private String logoTypePath;//org.sta.crrs.car_rental_reservation_system.items.logotypes

    @JsonIgnore
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<Branch> branch;


}
