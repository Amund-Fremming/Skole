package oblig2.web.entities;

import javax.persistence.*;

@Entity
@Table(name = "userr")
public class Userr {
	
	@Id
	private String mobile;
	
	private String fname;
	private String lname;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="addressid", referencedColumnName = "addressid")
	private Address addressid;
	
	private String password;

	public Userr() {}
	
	public Userr(String mobile, String fname, String lname, Address address, String password) {
		super();
		this.mobile = mobile;
		this.fname = fname;
		this.lname = lname;
		this.addressid = address;
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Address getAddressid() {
		return addressid;
	}

	public void setAddressid(Address address) {
		this.addressid = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
