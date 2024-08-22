package org.sta.crrs.car_rental_reservation_system.utils.dataTransferDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Rental;

@Data
@JsonIgnoreProperties({ "cars", "employees"})
public class BranchCreationDTO {
    private Long id;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private Rental rental;

}
