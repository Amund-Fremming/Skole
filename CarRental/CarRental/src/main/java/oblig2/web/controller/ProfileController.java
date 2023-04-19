package oblig2.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@GetMapping
	public String getProfileView(HttpSession session, RedirectAttributes ra) {
		
		return "profileView";
	}
	
}
