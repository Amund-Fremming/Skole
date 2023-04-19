package oblig2.web.entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer addressid;

	private String streetadr;
	private String postalcode;

	private String region;
	
	public Address() {}

	public Address(String streetadr, String postalcode, String region) {
		super();
		this.streetadr = streetadr;
		this.postalcode = postalcode;
		this.region = region;
	}

	public Integer getAddress_id() {
		return addressid;
	}

	public void setAddress_id(Integer address_id) {
		this.addressid = address_id;
	}

	public String getStreetadr() {
		return streetadr;
	}

	public void setStreetadr(String streetadr) {
		this.streetadr = streetadr;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


}
