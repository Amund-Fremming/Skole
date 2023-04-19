package oblig2.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oblig2.web.entities.Car;
import oblig2.web.repositories.UserRepo;
import oblig2.web.service.CarRentalService;
import oblig2.web.service.NewUserService;
import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {


	@Autowired UserRepo ur;
	@Autowired NewUserService us;
	
	@Autowired CarRentalService cs;
	
	@GetMapping
	public String getReceiptView(HttpServletRequest request, HttpSession session, RedirectAttributes ra) {
		
		if(!LoginUtil.isLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage", "You have to login first!");
			return "redirect:" + "login";
		}
		
		return "receiptView";
	}
	
}
