package mt.mas.hibernate;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Address {

	private long addressId;
	private String city;
	private String street;
	private String zipCode;
	private String apartmentNumber;

	/**
	 * Required by Hibernate
	 */
	public Address() { }

	public Address(String street, String city, String zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Address(String street, String city, String zipCode, String apartmentNumber) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.apartmentNumber = apartmentNumber;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	//@GenericGenerator(name="increment", strategy = "increment")
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	@Basic
	@NotNull
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Basic
	@NotNull
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Basic
	@NotNull
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Basic
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", getStreet(), getCity(), getZipCode());
	}



}
