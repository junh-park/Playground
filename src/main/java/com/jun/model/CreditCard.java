package com.jun.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AttributeOverride(
		name = "owner",
		column = @Column(name = "CC_OWNER", nullable = false)
		)
public class CreditCard extends BillingDetails {

	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	protected Long id;
	
	@NotNull protected String cardNumber;
	@NotNull String expMonth;
	@NotNull String expYear;

	public CreditCard() {}
	
	public CreditCard(String cardNumber, String expMonth, String expYear) {
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public Long getId() {
		return id;
	}
}
