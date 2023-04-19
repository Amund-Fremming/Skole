package oblig2.web.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import oblig2.web.entities.Address;
import oblig2.web.entities.Car;
import oblig2.web.entities.RentalOffice;
import oblig2.web.entities.Userr;
import oblig2.web.repositories.AddressRepo;
import oblig2.web.repositories.RentalOfficeRepo;
import oblig2.web.repositories.UserRepo;
import oblig2.web.service.NewUserService;
import oblig2.web.service.SearchService;

public class SearchServiceTest {
	
	private @Autowired SearchService ss;
	private @Autowired RentalOfficeRepo ro;

	@BeforeEach
	public void setup() {
		
	}
	
	@Test
	@DisplayName("Testing search results office 1")
	public void testSearchOffice1() {
		RentalOffice office = ro.findByOfficeid(1); 
		
		List<Car> results = ss.searchOffice(office);
		
		for(Car c : results) {
			assertTrue(c.getOfficeid().getOffice_id() == 1);
		}
		
	}
	
	@Test
	@DisplayName("Testing search results office 1")
	public void testSearchOffice2() {
		RentalOffice office = ro.findByOfficeid(2);
		
		List<Car> results = ss.searchOffice(office);
		
		for(Car c : results) {
			assertTrue(c.getOfficeid().getOffice_id() == 2);
		}
		
	}
	
	@Test
	@DisplayName("Testing search results office 1")
	public void testSearchOffice3() {
		RentalOffice office = ro.findByOfficeid(3); 
		
		List<Car> results = ss.searchOffice(office);
		
		for(Car c : results) {
			assertTrue(c.getOfficeid().getOffice_id() == 3);
		}
		
	}
	

}
