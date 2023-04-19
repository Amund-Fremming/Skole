package oblig2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oblig2.web.entities.Car;
import oblig2.web.entities.RentalOffice;
import oblig2.web.repositories.RentalOfficeRepo;
import oblig2.web.service.SearchService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired RentalOfficeRepo rentalOfficeRepo;
	@Autowired SearchService service;

	@GetMapping
	public String getHomeView(HttpServletRequest request) {
		List <RentalOffice> offices = rentalOfficeRepo.findAll();
		request.getSession().setAttribute("officeList", offices);
		return "homeView";
	}

	@PostMapping
	public String searchCarRental(RedirectAttributes ra,
			HttpServletRequest request,
			@RequestParam String rentalOffice,
			@RequestParam String dateFrom,
			@RequestParam String dateTo) {

		request.getSession().setAttribute("dateTo", dateTo);
		request.getSession().setAttribute("dateFrom", dateFrom);
		request.getSession().setAttribute("office", rentalOffice);

		RentalOffice ro = rentalOfficeRepo.findByName(rentalOffice);
		
		List<Car> carsF = service.searchOffice(ro);
		List <Car> carsAvailable = carsF.stream().filter(x -> x.isAvailable()).collect(Collectors.toList());
		request.getSession().setAttribute("availableCars", carsAvailable);


		return "redirect:" + "searchResult";
	}
}
