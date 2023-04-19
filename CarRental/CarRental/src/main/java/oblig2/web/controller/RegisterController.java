package oblig2.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oblig2.web.entities.Userr;
import oblig2.web.repositories.UserRepo;
import oblig2.web.service.NewUserService;
import oblig2.web.util.LoginUtil;
import oblig2.web.util.ValidatorUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired UserRepo userRepo;
	@Autowired NewUserService newUserService;

	@GetMapping
	public String getRegisterSchema() {
		return "registerView";
	}
	
	@PostMapping
	public String registerUser(@RequestParam String mobile,
			@RequestParam String fname, @RequestParam String lname,
			@RequestParam String password, @RequestParam String streetadr,
			@RequestParam String postalcode, @RequestParam String region,
			RedirectAttributes ra, HttpServletRequest request) {
		
		if (!ValidatorUtil.validateNumbersOnly(mobile) 
			|| !ValidatorUtil.validateTextOnly(fname)
			|| !ValidatorUtil.validateTextOnly(lname)
			|| !ValidatorUtil.validatePassword(password)
			|| !ValidatorUtil.validateStreetAdr(streetadr)
			|| !ValidatorUtil.validateNumbersOnly(postalcode)
			|| !ValidatorUtil.validateTextOnly(region)) {
			ra.addFlashAttribute("redirectMessage", "check that you have given the right datatype for the information");
			return "redirect:register";
		}
		
		if (userRepo.findByMobile(mobile)!= null) {
			ra.addFlashAttribute("redirectMessage", "user with given phone number already exists");
			return "redirect:register";
		} else {
			newUserService.newUser(mobile, fname, lname, password, streetadr, postalcode, region);
			Userr u = userRepo.findByMobile(mobile);
			LoginUtil.logIn(u, request.getSession());
			return "redirect:home";
		}
	}
	
}
