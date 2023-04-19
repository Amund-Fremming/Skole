package oblig2.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oblig2.web.entities.Userr;

@Repository
public interface UserRepo extends JpaRepository<Userr, String> {

	public Userr findByMobile(String mobile);
}
