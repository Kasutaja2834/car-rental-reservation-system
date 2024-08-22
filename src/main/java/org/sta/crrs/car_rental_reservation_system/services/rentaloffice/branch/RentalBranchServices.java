package org.sta.crrs.car_rental_reservation_system.services.rentaloffice.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Rental;
import org.sta.crrs.car_rental_reservation_system.repositories.rentaloffice.branch.RentalBranchRepository;

import java.util.List;

@Service
public class RentalBranchServices {

    private final RentalBranchRepository rentalBranchRepository;


    @Autowired
    public RentalBranchServices(RentalBranchRepository rentalBranchRepository) {
        this.rentalBranchRepository = rentalBranchRepository;
    }

    public List<Branch> findAllBranches() {
        return this.rentalBranchRepository.findAll();
    }

//    public List<Branch> findAllBranchesShort() {
//        return this.rentalBranchRepository.findAll();
//    }


    public Branch findBranchById(Long id) {
        return this.rentalBranchRepository.findById(id).get();//isPresent check
    }

    public List<Branch> findAllBranchesByRentalOffice(Rental rental) {
        return this.rentalBranchRepository.findBranchesByRental(rental);
    }

    public Boolean existRentalOfficeBranchById(Long branchId) {
        return this.rentalBranchRepository.existsById(branchId);
    }

    public Branch createBranch(Branch branch) {
        return this.rentalBranchRepository.save(branch);
    }


    public Branch updateBranch(Branch branch) {
        return this.rentalBranchRepository.save(branch);
    }

    public void deleteBranch(Long id) {
        this.rentalBranchRepository.deleteById(id);
    }


}
