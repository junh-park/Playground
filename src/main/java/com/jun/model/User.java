package com.jun.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	protected Long id;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
		@AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE")),
		@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
	})
	protected Address billingAddress;
	
	protected Address homeAddress;
	
	protected String username;
	
	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public BigDecimal calcShippingCosts(Address fromLocation) {
		return null;
	}
}
