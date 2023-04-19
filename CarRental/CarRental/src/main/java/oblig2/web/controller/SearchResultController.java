package oblig2.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oblig2.web.entities.Car;
import oblig2.web.repositories.CarRepo;

@Controller
@RequestMapping("/searchResult")
public class SearchResultController {
	
	@Autowired CarRepo carRepo;
	
	@GetMapping
	public String getSearchResultView() {
		return "searchResultView";
	}
	
	@PostMapping
	public String postSearchResult(HttpServletRequest request,
			@RequestParam String regnr) {
		
		Car car = carRepo.findByRegnr(regnr);
		
		request.getSession().setAttribute("car", car);
		return "redirect:rentCar";
		
	}
}
