package org.sta.crrs.car_rental_reservation_system.services.rentaloffice.rentaloffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Rental;
import org.sta.crrs.car_rental_reservation_system.repositories.rentaloffice.rental.RentalOfficeRepository;

import java.util.List;

@Service
public class RentalOfficeServices {
    private final RentalOfficeRepository rentalOfficeRepository;


    @Autowired
    public RentalOfficeServices(RentalOfficeRepository rentalOfficeRepository) {
        this.rentalOfficeRepository = rentalOfficeRepository;
    }

    public List<Rental> findAllRentalOffices( ) {
        return this.rentalOfficeRepository.findAll();
    }

    public Rental findRentalOfficeById(Long id) {
        return this.rentalOfficeRepository.findById(id).get(); //isPresent check??
    }

    public Boolean existsRentalOfficeById(Long id) {
        return this.rentalOfficeRepository.existsById(id);
    }

    public Rental createNewRentalOffice(Rental rental) {
        return this.rentalOfficeRepository.save(rental);
    }

    public Rental updateRentalOffice(Rental rental) {
        return this.rentalOfficeRepository.save(rental);
    }

    public void deleteRentalOffice(Long id) {
        this.rentalOfficeRepository.deleteById(id);
    }


}
