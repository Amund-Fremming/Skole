package oblig2.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oblig2.web.entities.RentalOffice;

@Repository
public interface RentalOfficeRepo extends JpaRepository<RentalOffice, Integer> {
	
	public RentalOffice findByOfficeid(Integer office_id);
	public RentalOffice findByName(String name);
	
}
