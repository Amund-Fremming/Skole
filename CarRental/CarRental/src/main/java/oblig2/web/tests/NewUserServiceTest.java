package oblig2.web.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import oblig2.web.entities.Address;
import oblig2.web.entities.Userr;
import oblig2.web.repositories.AddressRepo;
import oblig2.web.repositories.UserRepo;
import oblig2.web.service.NewUserService;

public class NewUserServiceTest {
	
	@Autowired NewUserService nuService;
	private String number = "99226633";
	
	@BeforeEach
	public void setup() {
		
	}
	
	@Test
	@DisplayName("Tests adding a new user to the DB")
	public void testNewUser() {
		Userr newUser = nuService.newUser(number, "Vendela", "Pilgaard", "passord", "morveien 69", "6969", "mordihula");
		String mobile = newUser.getMobile();
		Address adr = newUser.getAddressid();
		Integer adrId = adr.getAddress_id();
		
		assertTrue(nuService.getUser(mobile) != null);
		assertTrue(nuService.getAdr(adrId) != null);
	}
	
	@Test
	@DisplayName("Tests deleting a user from the DB")
	public void testDeleteUser() {
		nuService.deleteUser(number);
		
		assertTrue(nuService.getUser(number) == null);
	}
	
	
	
	
	

}
