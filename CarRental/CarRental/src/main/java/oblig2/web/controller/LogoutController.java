package oblig2.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oblig2.web.util.LoginUtil;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@GetMapping
	public String logout(HttpSession session) {
		
		LoginUtil.logOut(session);
		return "redirect:home";
		
	}
	
}
