package model;

import util.Concessions;
import util.StringFormatter;

public class Ticket {

	private int transactionID;
	private String performanceID;
	private String showName;
	private final String location = "The Theatre Royal";
	private Double price;
	private String startTime;
	private String date;
	private String seatType;
	private String concession;
	private String collectionID;

	private StringFormatter sf;

	public Ticket() {
		this.transactionID = 0;
		this.performanceID = null;
		this.showName = null;
		this.startTime = null;
		this.date = null;
		this.seatType = null;
		this.concession = null;
		this.price = null;
		this.collectionID = null;

		sf = new StringFormatter();
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getPerformanceID() {
		return performanceID;
	}

	public void setPerformanceID(String performanceID) {
		this.performanceID = performanceID;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Double getPrice() {
		return price;
	}

	public String getFormatPrice() {
		return sf.formatPrice(price);
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getConcession() {
		return concession;
	}

	public void setConcession(String concession) {
		this.concession = concession;
	}

	public String getLocation() {
		return location;
	}

	public String getCollectionID() {
		return collectionID;
	}

	public void setCollectionID(String collectionID) {
		this.collectionID = collectionID;
	}

	// applies the concession from the Concessions enum class
	// type of concession in a String must be entered
	public void applyConcession() {
		price = price * Concessions.Discounted.concessionApplied;
	}

	/**
	 * Print ticket method for displaying a ticket
	 */

	public void printTicket() {
		System.out.println("**********************************");
		System.out.println("             TICKET               ");
		System.out.println("                                  ");
		System.out.println(showName + " at " + location);
		System.out.println(date + " at " + startTime);
		System.out.println(sf.formatPrice(price) + "   type: " + concession);
		System.out.println("Seat: " + seatType);
		System.out.println("                                  ");
		System.out.println("          Enjoy the show!         ");
		System.out.println("**********************************");
	}

}