package oblig2.web.controller;

import javax.servlet.http.HttpServlet;
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
import oblig2.web.entities.Userr;
import oblig2.web.repositories.RentalRepo;
import oblig2.web.service.CarRentalService;
import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/deliver")
public class DeliverController {

	private @Autowired CarRentalService service;

	@GetMapping
	public String getDeliverController(HttpSession session, RedirectAttributes ra) {
		
		if(!LoginUtil.isLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage", "You have to login first!");
			return "redirect:" + "login";
		}
		
		return "deliverView";
	}
	
	@PostMapping
	public String postDelivery(HttpServletRequest request,
			@RequestParam String km_end) {
				
		Userr user = (Userr) request.getSession().getAttribute("user");
		Car car = (Car) request.getSession().getAttribute("car");
		
		service.deliverRental(user.getMobile(), car.getRegnr(), km_end);
		
		return "redirect:receipt";
	}
	
}
