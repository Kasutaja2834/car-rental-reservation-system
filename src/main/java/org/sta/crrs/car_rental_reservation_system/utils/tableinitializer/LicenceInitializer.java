package org.sta.crrs.car_rental_reservation_system.utils.tableinitializer;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.sta.crrs.car_rental_reservation_system.models.customer.Categories;
import org.sta.crrs.car_rental_reservation_system.models.customer.Licence;
import org.sta.crrs.car_rental_reservation_system.repositories.customer.LicenceRepository;

@Component
public class LicenceInitializer {

    private final LicenceRepository licenceRepository;

    @Autowired
    public LicenceInitializer(LicenceRepository licenceRepository) {
        this.licenceRepository = licenceRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        for (Categories categoryEnum : Categories.values()) {
            if (!licenceRepository.existsByCategory(categoryEnum)) {
                Licence licenceObj = new Licence();
                licenceObj.setCategory(categoryEnum);
                licenceObj.setValid(true);
                licenceRepository.save(licenceObj);
            }
        }
    }
}


