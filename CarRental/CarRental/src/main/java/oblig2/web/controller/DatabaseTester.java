package oblig2.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oblig2.web.entities.Car;
import oblig2.web.entities.Rental;
import oblig2.web.entities.RentalOffice;
import oblig2.web.entities.Userr;
import oblig2.web.repositories.RentalOfficeRepo;
import oblig2.web.service.CarRentalService;
import oblig2.web.service.NewUserService;
import oblig2.web.service.SearchService;

@Controller
public class DatabaseTester {
	
	@Autowired NewUserService us; 
	@Autowired SearchService ss;
	@Autowired RentalOfficeRepo roRepo;
	@Autowired CarRentalService rs;
	
	
	
	/* TESTS SEARCH-SERVICE */

	@GetMapping("/search")
	public String get() {
		
		RentalOffice office = roRepo.findByOfficeid(1);
		List<Car> li = ss.searchOffice(office);
		
		for(Car c : li) {
			System.err.println(c.getBrand() + " " + c.getModel() + " : " + c.getRegnr());
		}		
		
		return "homeView";
	}
	
	
	
	/* TESTS NEW-USER-SERVICE USERS */
	
	@GetMapping("/adduser")
	public String getA() {
		
		String number = "99226633";
		Userr newUser = us.newUser(number, "Vendela", "Pilgaard", "passord", "morveien 69", "6969", "mordihula");
		
		return "homeView";
	}
	
	
	@GetMapping("/deluser")
	public String getD() {
		
		String number = "99226633";
		us.deleteUser(number);
		
		return "homeView";
	}
	
	
	
	
	/* TESTS CAR-RENTAL-SERVICE */
	
	@GetMapping("/getcar")
	public String get1() {
		
		Car car = rs.getCar("EV55555");
		System.err.println(car.getRegnr());
		
		return "homeView";
	}
	
	@GetMapping("/issetavailable")
	public String get2() {
		
		boolean a = rs.isCarAvailable("EV55555");
		System.err.println("True: " + a);
		
		rs.setAvailability(false, "EV55555");
		
		// ETterpå
		boolean b = rs.isCarAvailable("EV55555");
		System.err.println("False: " + b);
		
		return "homeView";
	}
	
	
	@GetMapping("/getrentaluser")
	public String get4() {
		
		
		return "homeView";
	}
	
	@GetMapping("/getrental")
	public String get5() {
		
		Rental r = rs.getRental(1);
		System.err.println(r.getCreditcard());
		
		return "homeView";
	}
	
	@GetMapping("/getrentaloffice")
	public String get6() {
		
		RentalOffice ro = rs.getRentalOffice(1);
		System.err.println(ro.getName());
		
		return "homeView";
	}
	
	@GetMapping("/newrental")
	public String get7() {
		
		rs.newRental("55556666", "EV55555", "1234 1234 1234 1234", "0", null, null);
		
		return "homeView";
	}
	
	@GetMapping("/deliverrental")
	public String get8() {
		
		rs.deliverRental("55556666", "EV55555", "20000");
		
		return "homeView";
	}
	
	
	
}
