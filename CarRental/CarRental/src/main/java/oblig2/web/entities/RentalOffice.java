package oblig2.web.entities;

import javax.persistence.*;

@Entity
@Table(name = "rentaloffice")
public class RentalOffice {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer officeid;
	
	private String name;
	private String mobile;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="addressid", referencedColumnName = "addressid")
	private Address addressid;

	public RentalOffice() {}
	
	public RentalOffice(String name, String mobile, Address address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.addressid = address;
	}

	public Integer getOffice_id() {
		return officeid;
	}

	public void setOffice_id(Integer office_id) {
		this.officeid = office_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddressid() {
		return addressid;
	}

	public void setAddress(Address address) {
		this.addressid = address;
	}
	
	
	
	
}
