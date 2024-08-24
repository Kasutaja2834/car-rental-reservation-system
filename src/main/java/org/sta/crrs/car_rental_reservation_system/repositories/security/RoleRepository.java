package org.sta.crrs.car_rental_reservation_system.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.security.Role;
import org.sta.crrs.car_rental_reservation_system.models.security.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(Roles name);
    Role findRoleByName(Roles name);
}