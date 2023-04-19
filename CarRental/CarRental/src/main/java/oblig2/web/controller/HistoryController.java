package oblig2.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oblig2.web.entities.Userr;
import oblig2.web.repositories.RentalRepo;

import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/history")
public class HistoryController {
	
	private @Autowired RentalRepo rentalRepo;
	
	@GetMapping
	public String getHistoryView(HttpSession session, RedirectAttributes ra) {
		
		if(!LoginUtil.isLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage", "You have to login first!");
			return "redirect:" + "login";
		}
		
		Userr user = (Userr) session.getAttribute("user");
				
		return "historyView";
	}

}
