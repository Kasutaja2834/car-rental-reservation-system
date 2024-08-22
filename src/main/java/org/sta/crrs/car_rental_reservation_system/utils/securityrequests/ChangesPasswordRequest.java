package org.sta.crrs.car_rental_reservation_system.utils.securityrequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangesPasswordRequest {

    @NotNull
    private Long userID;

    @NotBlank
    private String oldPassword;

    @NotBlank
    @Size(min = 5, max = 120)
    private String newPassword;
}

