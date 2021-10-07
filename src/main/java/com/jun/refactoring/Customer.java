package com.jun.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		Iterator<Rental> rentalIterator = rentals.iterator();
		while (rentalIterator.hasNext()) {
			Rental each = (Rental) rentalIterator.next();
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	public String htmlStatement() {
 		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		
		Iterator<Rental> rentalIterator = rentals.iterator();
		while (rentalIterator.hasNext()) {
			Rental each = (Rental) rentalIterator.next();
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}
		
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : rentals)
			result += rental.getCharge();
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : rentals)
			result += rental.getFrequentRenterPoints();
		return result;
	}

}
