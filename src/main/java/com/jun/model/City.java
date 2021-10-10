package com.jun.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class City {

	@NotNull
	@Column(nullable = false, length = 5)
	protected String zipcode;

	@NotNull
	@Column(nullable = false)
	protected String city;

	@NotNull
	@Column(nullable = false)
	protected String country;

	public City() {	}
	
	public City(String zipcode, String city, String country) {
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
