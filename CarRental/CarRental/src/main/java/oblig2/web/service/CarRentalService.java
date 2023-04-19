package oblig2.web.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oblig2.web.entities.Car;
import oblig2.web.entities.Rental;
import oblig2.web.entities.RentalOffice;
import oblig2.web.entities.Userr;
import oblig2.web.repositories.CarRepo;
import oblig2.web.repositories.RentalOfficeRepo;
import oblig2.web.repositories.RentalRepo;
import oblig2.web.repositories.UserRepo;

import oblig2.web.entities.Address;
/**
 * 
 * @author AmundFremming, DennisOsmani
 *
 */

@Service
public class CarRentalService {
	
	private @Autowired CarRepo carRepo;
	private @Autowired UserRepo userRepo;
	private @Autowired RentalOfficeRepo roRepo;
	private @Autowired RentalRepo rentalRepo;
	
	/**
	 * Checks the database for cars with given regnr
	 * 
	 * @param regnr
	 * @return Car object
	 */
	public Car getCar(String regnr) {
		
		return carRepo.findByRegnr(regnr);
		
	}
	
	/**
	 * @param regnr
	 * @return true if car is available
	 */
	public boolean isCarAvailable(String regnr) {
		
		Car car = carRepo.findByRegnr(regnr);
		
		if (car.isAvailable()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Sets the availablility of the given car
	 *
	 * @param value
	 */
	public void setAvailability(boolean value, String regnr) {
		
		Car car = carRepo.findByRegnr(regnr);
		
		car.setAvailable(value);
	}
	
	/**
	 * @param mobile
	 * @return the User that is renting the car
	 */
	public Userr getRentalUser(String mobile) {
		return null;
		// TODO
		// Må sjekke rental entity og car entoity for å returnere riktig bruker
	}
	
	/**
	 * @param id
	 * @return the id of the rental process
	 */
	public Rental getRental(int id) {
		
		return rentalRepo.findByRentalid(id);
		
	}
	
	/**
	 * @param id
	 * @return the id of the office where 
	 * the rental is being done
	 */
	public RentalOffice getRentalOffice(int id) {
		 return roRepo.findByOfficeid(id);
	}
	
	/**
	 * create a new rental object
	 * @param mobile, regnr, creditcard, km_start, dt_start, dt_end
	 * @return the Rental object
	 */
	public Rental newRental(String mobile, String regnr, String creditcard, 
			String km_start, String dt_start, String dt_end) {
		 

		Car car = carRepo.findByRegnr(regnr);
		car.setAvailable(false);
		carRepo.save(car);
		
		Userr k = userRepo.findByMobile(mobile);
		
		Rental rental = new Rental(k, car, creditcard, km_start, dt_start, km_start, dt_end);
		rentalRepo.save(rental);
		
		return rental; //h
		
	}
	
	/**
	 * deliver a rental object
	 * @param mobile, regnr, km_driven
	 * @return the rental objectS
	 */
	public Rental deliverRental(String mobile, String regnr, String km_driven) {
   		 Car car = carRepo.findByRegnr(regnr);
		 List <Rental> list = rentalRepo.findByRegnr(car);
		 
		 if(list.size() < 0) {
			 return null;
		 }
		 
		 Rental rent = null;
		 
		 for(Rental r : list) {
			 if(r.getMobile().getMobile().equals(mobile)) {
				 rent = r;
			 }
		 }
		 
		 int km_end = Integer.parseInt(rent.getKm_start());
		 int driven = Integer.parseInt(km_driven);
		 rent.setKm_end(String.valueOf(km_end+driven));
		 
		 car.setAvailable(true);
		 carRepo.save(car);
		 
		 return rent;
	}
	
}
