package oblig2.web.entities;

import java.util.Optional;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

	@Id
	private String regnr;
	
	private String brand;
	private String model;
	private String color;
	private String sizegroup;
	private boolean available;
	private String img;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="officeid", referencedColumnName = "officeid")
	private RentalOffice officeid;

	public Car(String regnr, String brand, String model, String color, String sizegroup, boolean available, String img,
			RentalOffice office) {
		super();
		this.regnr = regnr;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.sizegroup = sizegroup;
		this.available = available;
		this.img = img;
		this.officeid = office;
	}
	
	public Car() {}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSizegroup() {
		return sizegroup;
	}

	public void setSizegroup(String sizegroup) {
		this.sizegroup = sizegroup;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public RentalOffice getOfficeid() {
		return officeid;
	}

	public void setOfficeid(RentalOffice office) {
		this.officeid = office;
	}
	
	
}
