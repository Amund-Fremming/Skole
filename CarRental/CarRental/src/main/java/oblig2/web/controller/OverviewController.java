package oblig2.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oblig2.web.entities.Rental;
import oblig2.web.repositories.RentalRepo;

@Controller
@RequestMapping("/oversikt")
public class OverviewController {

	
	@Autowired RentalRepo rr;
	
	@GetMapping
	public String oversiktView(HttpServletRequest request) {
		
		List<Rental> allRentals = rr.findAll();
		
		List<Rental> aktive = allRentals.stream().filter(r -> r.getKm_end().equals("0")).toList();		
		request.getSession().setAttribute("aktive", aktive);
		
		return "oversiktView";
	}
}
