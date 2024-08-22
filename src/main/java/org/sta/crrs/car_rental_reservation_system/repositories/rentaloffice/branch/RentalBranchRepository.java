package org.sta.crrs.car_rental_reservation_system.repositories.rentaloffice.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Branch;
import org.sta.crrs.car_rental_reservation_system.models.rentaloffice.Rental;

import java.util.List;

@Repository
public interface RentalBranchRepository extends JpaRepository<Branch,Long> {
    List<Branch> findBranchesByRental(Rental rental);

    // List<Grade> findGradesByCourseAndScoreGreaterThan(Course course, Double score);
    // and in the case spring is not flexible enough, you can make your own query
    // @Query("SELECT grade FROM Grade grade WHERE grade.course = :course AND grade.score > :score")
    // List<Grade> findGradesByCourseAndScoreGreaterThan(@Param("course") Course course, @Param("score") Double score);


//List<Branch>
}
