package oblig2.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import oblig2.web.util.ValidatorUtil;
import oblig2.web.repositories.RentalRepo;
import oblig2.web.repositories.UserRepo;
import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired UserRepo userRepo;
	@Autowired RentalRepo rentalRepo;
	
	@GetMapping
	public String getLoginSchemas() {
		return "loginView";
	}
	
	@PostMapping
	public String tryLogin(@RequestParam String mobile,
			@RequestParam String password, HttpServletRequest request, 
			RedirectAttributes ra) {
		
		Userr u = userRepo.findByMobile(mobile);
		List<Rental> rental = rentalRepo.findByMobile(u);
		List<Rental> rentN = rental.stream().filter(r -> r.getKm_end().equals("0")).toList();

		/* HENTER BIL TIL BRUKER SOM LOGGES INN */
		
		if(u != null && rentN.size() > 0) {
			Car car = rentN.get(0).getRegnr();
			request.getSession().setAttribute("car", car);
		}
		
		/* - - - - - - - - - - - - - - - - - - - */
		
				
		if(u == null) {
			ra.addFlashAttribute("redirectMessage", "user with given number doesnt exist, register below!");
			return "redirect:" + "login";
		} else if(!u.getPassword().equals(password)) {
			ra.addFlashAttribute("redirectMessage", "wrong password, try again");
			return "redirect:" + "login";
			
			
		} else {
			
			if (!ValidatorUtil.validateNumbersOnly(mobile)) {
				ra.addFlashAttribute("redirectMessage", "mobile should be only numbers");
				return "redirect:" + "login";
			} else if(!ValidatorUtil.validatePassword(password)) {
				ra.addFlashAttribute("redirectMessage", "password should contain one small, one large, one number and be 8-20 characters");
				return "redirect:" + "login";
			} else {
				
				request.getSession().setAttribute("innlogget", "Logget inn: " + u.getFname() + " " + u.getLname());
				
				if (u.getMobile().equals("11111111") && u.getPassword().equals("Admin123")) {
					return "redirect:" + "oversikt";
				}
				
				LoginUtil.logIn(u, request.getSession());
				return "redirect:" + "home";
			}
			
		}
		
	}
	
}
