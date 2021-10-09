package com.jun.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	protected String username;
	
	public User() {
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
