package oblig2.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oblig2.web.entities.Car;
import oblig2.web.entities.RentalOffice;
import oblig2.web.repositories.CarRepo;
import oblig2.web.repositories.RentalOfficeRepo;

/**
 * Utility class for searching cars for a given office
 * 
 * @author AmundFremming
 *
 */

@Service
public class SearchService {
	
	private @Autowired CarRepo carRepo;
	
	/**
	 * Searches the database for cars for a given office
	 * 
	 * @return List of cars for a given office
	 */
	public List<Car> searchOffice(RentalOffice office_id) {
		return carRepo.findByOfficeid(office_id);	
	}

}
