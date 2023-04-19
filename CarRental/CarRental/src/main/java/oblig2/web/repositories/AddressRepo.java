package oblig2.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oblig2.web.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	Address findByAddressid(Integer address_id);
	
}
