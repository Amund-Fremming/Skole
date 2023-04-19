package oblig2.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oblig2.web.entities.Address;
import oblig2.web.entities.Userr;
import oblig2.web.repositories.AddressRepo;
import oblig2.web.repositories.UserRepo;

/**
 * @author adrian berget
 * 
 */

@Service
public class NewUserService {

	private @Autowired UserRepo userRepo;
	private @Autowired AddressRepo addressRepo;
	
	public NewUserService() {}
	
	/**
	 * Saves address and new user to databases
	 * 
	 * @param mobile, fname, lname, password, streetadr, postalcode, region
	 * @return 
	 * 
	 */
	public Userr newUser(String mobile, String fname, String lname
			,String password, String streetadr, String postalcode
			,String region) {
		
		Address adr = new Address(streetadr, postalcode, region);
		Userr user = new Userr(mobile, fname, lname, adr, password);
		
		if(!addressRepo.findAll().contains(adr)){
			addressRepo.save(adr);
		}
		
		if(userRepo.findByMobile(mobile) == null) {
			userRepo.save(user);
		}
		
		return user;
	}
	
	/**
	 * @param mobile
	 * @return deleted user
	 */
	public Userr deleteUser(String mobile) {
		Userr u = userRepo.findByMobile(mobile);
		userRepo.delete(u);
		return u;
	}
	
	public Userr getUser(String mobile) {
		return userRepo.findByMobile(mobile);
	}
	
	public Address getAdr(Integer adrId) {
		return addressRepo.findByAddressid(adrId);
	}
}


