package oblig2.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oblig2.web.entities.Car;
import oblig2.web.entities.RentalOffice;

@Repository
public interface CarRepo extends JpaRepository<Car, String> {

	Car findByRegnr(String regnr);
	List<Car> findByOfficeid(RentalOffice office);
	
}
