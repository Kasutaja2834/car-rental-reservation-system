package org.sta.crrs.car_rental_reservation_system.utils.dataTransferDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Position;
import org.sta.crrs.car_rental_reservation_system.models.security.Role;

@Data
@JsonIgnoreProperties({"branch"})
public class EmployeeCreationDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String username;
    private String password;
    private String email;
    private Position position;
    private Branch branch;

}


