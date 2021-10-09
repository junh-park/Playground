package com.jun.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item {

	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	protected Long id;

	@NotNull
	@Size(min = 2, max = 255, message = "Name is required, maximum 255 characters.")
	protected String name;

	@Future
	protected Date auctionEnd;

	public Long getId() {
		return id;
	}

	protected Set<Bid> bids = new HashSet<Bid>();

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public void addBid(Bid bid) {
		if (bid == null)
			throw new NullPointerException("Can't add null Bid");
		if (bid.getItem() != null)
			throw new IllegalStateException("Bid is already assigned to an Item");

		getBids().add(bid);
		bid.setItem(this);
	}
}
