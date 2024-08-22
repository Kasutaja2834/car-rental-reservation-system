package org.sta.crrs.car_rental_reservation_system.models.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sta.crrs.car_rental_reservation_system.models.reservation.Reservation;
import org.sta.crrs.car_rental_reservation_system.models.security.Role;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Entity(name = "users")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String addressCity;
    private String addressCountry;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 120)
//@JsonIgnore -  do not serialize
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Reservation>  reservation;

    @OneToMany
    List<Licence> licence; //Driving licence and right to drive
}
//Address search bar without a map Only the address search box is displayed. In this mode only address-based search is enabled.
//interface http://inaadress.maaamet.ee/inaadress
// In-ADS widget
//Additionally, the ID value of a DIV element, into which the In-ADS widget will be placed, must be set.


//HTML lehe päis:
//<script type="text/javascript" src="https://inaadress.maaamet.ee/inaadress/js/inaadress.min.js?d=20220510"></script>
//Javascript kood In-ADS käivitamiseks:
//var inAadress = new InAadress({"container":"InAadressDiv","mode":3,"ihist":"1993","appartment":0,"lang":"et"});
//Näidis HTML leht:
//<!DOCTYPE HTML>
//<html>
//<head>
//<title>In-ADS komponent</title>
//<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
//<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
//<script type="text/javascript" src="https://inaadress.maaamet.ee/inaadress/js/inaadress.min.js?d=20220510"></script>
//</head>
//<body>
//<div id="InAadressDiv" style="width: 600px; height: 450px"></div>
//<script>
//var inAadress = new InAadress({"container":"InAadressDiv","mode":3,"ihist":"1993","appartment":0,"lang":"et"});
//</script>
//</body>
//</html>
//Täpsemalt saate komponendi seadete, omaduste ja juhtimisega tutvuda In-ADS komponendi arendusjuhendis.