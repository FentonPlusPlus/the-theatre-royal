package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import util.StringFormatter;

public class Basket {

	public ArrayList<Ticket> tickets;
	private Double basketTotal;
	private boolean postage;
	private StringFormatter sf;
	private DateTimeFormatter dtf;

	public Basket() {
		tickets = new ArrayList<>();
		basketTotal = 0.00;
		postage = false;

		sf = new StringFormatter();

	}

	// postage options

	public void applyPostage() {
		postage = true;
		for (int i = 0; i < tickets.size(); i++) {
			tickets.get(i).setCollectionID("Posted");
		}
	}

	public void setPostageFalse() {
		postage = false;
	}

	public boolean getPostage() {
		return postage;
	}

	public boolean checkPostageApplies() {
		// get local date as String
		String localDate = LocalDate.now().toString();
		// get localDate formatted as Date
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = formatter.parse(localDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < tickets.size(); i++) {
			String tDate = tickets.get(i).getDate();
			Date ticketDate = null;
			try {
				ticketDate = formatter.parse(tDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long timeDifference = ticketDate.getTime() - currentDate.getTime();
			long daysDifference = (timeDifference / (1000 * 60 * 60 * 24)) % 365;
			if (daysDifference <= 6) {
				return false;
			}
		}
		// if for loop doesn't return false
		// all dates are valid for postage
		return true;
	}

	/**
	 * Basket methods
	 */

	// clears the basket completely
	// we should never have to reset the basket without also resetting the tickets
	// ArrayList
	public void clearBasket() {
		tickets = new ArrayList<Ticket>();
		basketTotal = 0.00;
	}

	public double getBasketTotal() {
		double t = 0.00;
		for (int i = 0; i < tickets.size(); i++) {
			t = t + tickets.get(i).getPrice();
		}
		basketTotal = t;
		return basketTotal;
	}

	public double getBasketTotalWithPostage() {
		double t = 0.00;
		for (int i = 0; i < tickets.size(); i++) {
			t = t + tickets.get(i).getPrice();
		}
		basketTotal = t;
		// find which tickets have postage applied and store that in a variable
		int n = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getConcession().equals("Regular")) {
				// do nothing
			} else {
				n = n + 1;
			}
		}
		// all tickets are concessions no postage fee
		if (n == tickets.size()) {
			return basketTotal;
		}
		// if at least 1 or more, but not all are concessions then add 1.00
		else if (n >= 1) {
			basketTotal = basketTotal + 1.00;
		}
		// otherwise add 1.00 for all tickets in arrayList
		else if (n == 0) {
			basketTotal = basketTotal + (tickets.size() * 1.00);
		}
		return basketTotal;
	}

	/**
	 * 
	 * Ticket methods. Get total tickets in ArrayList Add tickets to ArrayList.
	 * PrintAllTickets method which also clears the basket.
	 */
	public int getNoOfTotalTickets() {
		return tickets.size();
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	/**
	 * print all tickets method not currently implemented
	 */
	public void printAllTickets() {
		int t = 0;
		for (Ticket ticket : tickets) {
			System.out.println("\n **Printing: Ticket " + t + "**\n");
			ticket.printTicket();
			t++;
		}
		System.out.println(
				"All tickets have been printed and stored to your Transaction ID which can be found on your ticket.");
		System.out.println("Thank you and we look forward to seeing you!");
		clearBasket();
	}

	// set transactionID of all tickets
	public void setTransactionIdOfAll(int id) {
		for (int i = 0; i < tickets.size(); i++) {
			tickets.get(i).setTransactionID(id);
		}
	}

	public void displayBasket() {
		System.out.println("Your Shopping Basket:\n");
		int tn = 1;
		for (int i = 0; i < tickets.size(); i++) {
			String sN = tickets.get(i).getShowName();
			String sD = tickets.get(i).getDate();
			String sT = tickets.get(i).getStartTime();
			String sE = tickets.get(i).getSeatType();
			String co = tickets.get(i).getConcession();
			String pr = tickets.get(i).getFormatPrice();
			System.out.println("Ticket " + tn + "| Concert: " + sN + " Date: " + sD + " Time: " + sT + " Seat: " + sE
					+ " Conc: " + co + " Price: " + pr);
			tn++;
		}
		setPostageFalse();
		double bt = getBasketTotal();
		System.out.println("\nThe total of your basket is: " + sf.formatPrice(bt) + "\n");
	}

	public int getCircleAmount() {
		int circleAmount = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getSeatType().equals("Circle")) {
				circleAmount++;
			}
		}
		return circleAmount;
	}

	public int getStallAmount() {
		int stallsAmount = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getSeatType().equals("Stalls")) {
				stallsAmount++;
			}
		}
		return stallsAmount;
	}
}