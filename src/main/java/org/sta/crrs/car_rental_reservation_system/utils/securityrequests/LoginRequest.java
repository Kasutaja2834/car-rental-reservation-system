package org.sta.crrs.car_rental_reservation_system.utils.securityrequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {


    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
