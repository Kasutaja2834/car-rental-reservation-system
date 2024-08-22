package org.sta.crrs.car_rental_reservation_system.utils.securityrequests;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.sta.crrs.car_rental_reservation_system.models.security.Role;
import org.sta.crrs.car_rental_reservation_system.models.security.Roles;
import org.sta.crrs.car_rental_reservation_system.repositories.security.RoleRepository;

@Component
public class RoleInitializer {


    private final RoleRepository roleRepository;

    @Autowired
    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        for (Roles roleEnum :  Roles.values()) {
            if (!roleRepository.existsByName(roleEnum)) {
                Role role = new Role();
                role.setName(roleEnum);
                roleRepository.save(role);
            }
        }
    }
}

