package oblig2.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oblig2.web.entities.Car;
import oblig2.web.entities.Rental;
import oblig2.web.entities.Userr;
import oblig2.web.service.CarRentalService;
import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/rentCar")
public class RentCarController {

	@Autowired CarRentalService cs;
	
	@GetMapping
	public String getRentCarView(HttpSession session, RedirectAttributes ra) {

		if(!LoginUtil.isLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage", "You have to login first!");
			return "redirect:" + "login";
		}
		
		return "rentCarView";
	}
	
	@PostMapping
	public String RentCar(HttpServletRequest request, 
						@RequestParam String creditcard) {
		
			Userr user = (Userr) request.getSession().getAttribute("user");
			Car car = (Car) request.getSession().getAttribute("car");
			
			String dt_start = (String) request.getSession().getAttribute("dateTo");
			String dt_end = (String) request.getSession().getAttribute("dateFrom");
		
			request.getSession().setAttribute("creditcard", creditcard);
			
			String km_start = "0";
			
//			request.getSession().setAttribute("km_start", km_start);
			
			Rental rental = cs.newRental(user.getMobile(), car.getRegnr(), creditcard, km_start, dt_start, dt_end);
		
			request.getSession().setAttribute("rental", rental);
			
		return "redirect:" + "receipt";
		
	}
}
