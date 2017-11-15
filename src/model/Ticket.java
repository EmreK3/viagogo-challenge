package model;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class Ticket implements Comparable<Ticket> {
	
	private Currency curr;
	private int eventID;
	private double price;
	
	/**
	 * By allowing a tickets locale to be passed in
	 * as a parameter, we enable the support for different
	 * currencies; should we need it down the line.
	 * For now though, it has been set to USD by default.
	 */
	
	public Ticket(int eventID, /*Locale locale,*/ double price) {
		this.eventID = eventID;
		curr = Currency.getInstance(Locale.US);
		this.price = price;
	}
	
	@Override
	public int compareTo(Ticket t) {
		if(price == t.getPrice()) {
			return 0;
		} else if(price > t.getPrice()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return "Event " + eventID + " - " + getPriceString() + ",";
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getPriceString() {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		return curr.getSymbol() + " " + formatter.format(price);
	}

	
}
