package oblig2.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import oblig2.web.entities.Car;
import oblig2.web.entities.Rental;
import oblig2.web.entities.Userr;

@Repository
public interface RentalRepo extends JpaRepository<Rental, Integer> {
	
	Rental findByRentalid(Integer id);
	List <Rental> findByMobile(Userr mobile);
	List <Rental> findByRegnr(Car car);
}
