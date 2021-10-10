package com.jun.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	protected Long id;

	@Access(AccessType.PROPERTY)
	@Column(name = "ITEM_NAME")
	protected String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected AuctionType auctionType = AuctionType.HIGHEST_BID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = !name.startsWith("AUCTION") ? "AUCTION" + name : name;
	}

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
