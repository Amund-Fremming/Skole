package oblig2.web.entities;

import java.time.*;

import javax.persistence.*;

@Entity
@Table(name = "rental")
public class Rental {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer rentalid;
	
	private String creditcard;
	private String km_start;
	private String dt_start;
	private String km_end;
	private String dt_end;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mobile", referencedColumnName = "mobile")
	private Userr mobile;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="regnr", referencedColumnName = "regnr")
	private Car regnr;

	public Rental() {}
	
	public Rental(Userr mobile, Car regnr, String creditcard, String km_start, String dt_start, String km_end,
			String dt_end) {
		super();
		this.creditcard = creditcard;
		this.km_start = km_start;
		this.dt_start = dt_start;
		this.km_end = km_end;
		this.dt_end = dt_end;
		this.mobile = mobile;
		this.regnr = regnr;
	}

	public Integer getRental_id() {
		return rentalid;
	}

	public void setRental_id(Integer rental_id) {
		this.rentalid = rental_id;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getKm_start() {
		return km_start;
	}

	public void setKm_start(String km_start) {
		this.km_start = km_start;
	}

	public String getDt_start() {
		return dt_start;
	}

	public void setDt_start(String dt_start) {
		this.dt_start = dt_start;
	}

	public String getKm_end() {
		return km_end;
	}

	public void setKm_end(String km_end) {
		this.km_end = km_end;
	}

	public String getDt_end() {
		return dt_end;
	}

	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}

	public Userr getMobile() {
		return mobile;
	}

	public void setMobile(Userr mobile) {
		this.mobile = mobile;
	}

	public Car getRegnr() {
		return regnr;
	}

	public void setRegnr(Car regnr) {
		this.regnr = regnr;
	}
	
	
}
