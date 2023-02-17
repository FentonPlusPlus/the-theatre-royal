package controller;

import model.Basket;
import model.Ticket;
import util.DBConnector;
import util.InputReader;
import util.InputValidator;

public class BackEndController {
	private DBConnector db;
	private InputReader in;
	private Basket basket;
	private Ticket ticket;
	private InputValidator inputValidator;

	public BackEndController() {
		db = new DBConnector();
		in = new InputReader();
		basket = new Basket();
		ticket = new Ticket();
		inputValidator = new InputValidator();

		// connect to the database
		db.connect();
	}

	public void welcome() {
		System.out.println("Welcome to the Theatre Royal");
	}

	public void exit() {
		System.out.println("We look forward to seeing you soon. Thank you.");
	}

	public void mainMenu() {

		welcome();
		System.out.println();
		System.out.println("Please type a number to choose an option");
		System.out.println();
		System.out.println(formatter());
		System.out.println("1 - View What's On/Calendar");
		System.out.println("2 - View basket");
		// System.out.println("3 - Employee login");
		System.out.println("3 - Exit");
		System.out.println(formatter());

		boolean exit = false;

		do {
			switch (in.getNumber("")) {
			case 1:
				showCalendar();
				break;
			case 2:
				System.out.println("Insert basket method");
				viewBasket();
				// loopBackMenu();
				break;
			// case 3:
			// System.out.println("Insert employee method");
			// loopBackMenu();
			// break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Error: You must choose a valid option");

			}
		} while (!exit);
		exit();
	}

	public String formatter() {
		return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	}

	public void showCalendar() {

		System.out.println("Please choose an option");
		System.out.println(formatter());
		System.out.println("1 - View all shows");
		System.out.println("2 - Browse shows by name");
		System.out.println("3 - Browse shows by date");
		System.out.println("4 - Main menu");
		System.out.println("5 - Exit");
		System.out.println(formatter());

		boolean exit = false;

		do {
			switch (in.getNumber("")) {
			case 1:
				System.out.println("Here are all available shows:");
				db.listShowProduction();
				System.out.println();
				buyMethod();
				break;
			case 2:
				db.searchShowByName();
				System.out.println();
				buyMethod();
				break;
			case 3:
				db.searchShowByDate();
				System.out.println();
				buyMethod();
				break;
			case 4:
				mainMenu();
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Error: You must choose a valid option");
			}
		} while (!exit);
		exit();
	}

	public void loopBackMenu() {
		System.out.println("Please choose an option");
		System.out.println(formatter());
		System.out.println("1 - Buy ticket/(S)");
		System.out.println("2 - Show Calendar");
		System.out.println("3 - Main menu");
		System.out.println(formatter());

		switch (in.getNumber("")) {
		case 1:
			System.out.println("Insert Buy ticket method");
			loopBackMenu();
			break;
		case 2:
			showCalendar();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void buyMethod() {
		System.out.println("Please choose an option");
		System.out.println(formatter());
		System.out.println("1 - Buy ticket");
		System.out.println("2 - Search for another show");
		System.out.println("3 - Main menu");
		System.out.println(formatter());

		switch (in.getNumber("")) {
		case 1:
			db.userIDInput();
			showConfirmation();
			break;
		case 2:
			showCalendar();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void showConfirmation() {
		System.out.println(formatter());
		System.out.println("Is this the correct ticket");
		System.out.println("1 - Yes");
		System.out.println("2 - No");
		switch (in.getNumber("")) {
		case 1:
			newTicket();
			break;
		case 2:
			buyMethod();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void newTicket() {

		// create a new ticket
		Ticket ticket = new Ticket();

		// user selects seat Type
		System.out.println("Enter Seat type:");
		System.out.println("1- Circle");
		System.out.println("2- Stalls");
		String seatType = "";
		switch (in.getNumber("")) {
		case 1:
			double circlePrice = db.circlePrice();
			ticket.setPrice(circlePrice);
			seatType = "Circle";
			ticket.setSeatType(seatType);
			break;
		case 2:
			double stallsPrice = db.stallsPrice();
			ticket.setPrice(stallsPrice);
			seatType = "Stalls";
			ticket.setSeatType(seatType);
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}

		// user select concession options
		System.out.println("Enter Concession type:");
		System.out.println("1- Regular (no concession)");
		System.out.println("2- Student");
		System.out.println("3- Under 16");
		System.out.println("4- Other");
		String concession = "";
		switch (in.getNumber("")) {
		case 1:
			concession = "Regular";
			ticket.setConcession(concession);
			break;
		case 2:
			concession = "Student";
			ticket.setConcession(concession);
			ticket.applyConcession();
			break;
		case 3:
			concession = "Under 16";
			ticket.setConcession(concession);
			ticket.applyConcession();
			break;
		case 4:
			concession = "Other";
			ticket.setConcession(concession);
			ticket.applyConcession();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}

		// set ticket info (showName, duration, performance, starttime)
		ticket.setShowName(db.ticket.getShowName());
		ticket.setDate(db.ticket.getDate());
		ticket.setPerformanceID(db.ticket.getPerformanceID());
		ticket.setStartTime(db.ticket.getStartTime());

		// basket add ticket
		basket.addTicket(ticket);

		System.out.println("Your ticket has been added to your basket.");
		System.out.println("Would you like to add another ticket?");
		System.out.println("1- Add another ticket");
		System.out.println("2- View Basket");
		System.out.println("3- Back to main menu");
		switch (in.getNumber("")) {
		case 1:
			newTicket();
			break;
		case 2:
			viewBasket();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}

	}

	public void viewBasket() {

		// display contents of basket
		basket.displayBasket();

		System.out.println("Please choose an option");
		System.out.println(formatter());
		System.out.println("1 - Go to payment");
		System.out.println("2 - Clear basket");
		System.out.println("3 - Return to main menu");
		System.out.println(formatter());

		switch (in.getNumber("")) {
		case 1:
			db.setCustomerInfo();
			postage();
			break;
		case 2:
			ClearBasket();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("Error: You must choose a valid option");
		}
	}

	public void postage() {
		if (basket.checkPostageApplies()) {
			System.out.println("Would you like to apply postage to your order?");
			System.out.println("Postage costs £1 per ticket. "
					+ "If your order contains a concession ticket, postage will be £1 for the entire order."
					+ " If all your tickets are a concession ticket, postage will be free");
			System.out.println("");
			System.out.println("1- Yes, I'd like to apply postage");
			System.out.println("2- No, I do not want postage");
			switch (in.getNumber("")) {
			case 1:
				basket.applyPostage();
				System.out.println("Your new basket total is: �" + basket.getBasketTotalWithPostage());
				System.out.print("Proceeding to payment.");
				paymentMenu();
				break;
			case 2:
				System.out.println(
						"Okay. On confirmation of your order you will be able to collect your tickets at our box office.");
				paymentMenu();
				break;
			default:
				System.out.println("Error: You must choose a valid option");
			}
		} else {
			paymentMenu();
		}
	}

	public void paymentMenu() {
		System.out.println("");
		System.out.println("In order to confirm your payment please enter your Credit Card number");
		String ccNo = in.getText("");
		if (inputValidator.validateCreditCard(ccNo)) {
			System.out.println("Details are correct. Processing your order now.");
			// go to process payment
			processPayment();
		} else {
			System.out.println("The credit card number you entered was invalid.");
			System.out.println(
					"Please check that your credit card number is 16 characters long, and has no spaces or '-'.");
			System.out.println("Please choose an option");
			System.out.println(formatter());
			System.out.println("1 - Try entering my credit card number again");
			System.out.println("2 - Back to basket");
			switch (in.getNumber("")) {
			case 1:
				paymentMenu();
				break;
			case 2:
				viewBasket();
				break;
			default:
				System.out.println("Error: You must choose a valid option");
			}
		}
	}

	public void processPayment() {

		// adds the customer to the database
		db.injectCustomerInfo();

		// updates the availability in the relative performance database
		db.insertTransactionID();

		// updates transactionID iterating through the basket
		int transactionID = db.lastTransactionID();
		for (int i = 0; i < basket.tickets.size(); i++) {
			basket.tickets.get(i).setTransactionID(transactionID);
		}

		// updates seat availibility in database for each seat type iterating through
		// basket
		for (int i = 0; i < basket.tickets.size(); i++) {
			String performanceId = basket.tickets.get(i).getPerformanceID();
			if (basket.tickets.get(i).getSeatType().equals("Circle")) {
				db.updateSeatAvailibilityCirlce(performanceId);
			} else if (basket.tickets.get(i).getSeatType().equals("Stalls")) {
				db.updateSeatAvailibilityStalls(performanceId);
			}
		}

		// sets parameters for ticket table in the database
		for (int i = 0; i < basket.tickets.size(); i++) {
			int transID = basket.tickets.get(i).getTransactionID();
			String perfID = basket.tickets.get(i).getPerformanceID();
			String collectID = basket.tickets.get(i).getCollectionID();
			Double price = basket.tickets.get(i).getPrice();
			int concID = 1;
			if (basket.tickets.get(i).getConcession().equals("Regular")) {
				concID = 1;
			} else if (basket.tickets.get(i).getConcession().equals("Student")) {
				concID = 2;
			} else if (basket.tickets.get(i).getConcession().equals("Under 16")) {
				concID = 3;
			} else {
				concID = 4;
			}
			// inserts ticket info to ticket database
			db.injectTicketInfo(transID, perfID, concID, collectID, price);
		}

		// clear the basket
		basket.clearBasket();
		System.out.println("We look forward to seeing you soon. Thank you.");

		mainMenu();

	}

	public void ClearBasket() {
		if (basket.getNoOfTotalTickets() >= 1) {
			System.out.println("Are you sure you wish to clear your basket?");
			System.out.println(formatter());
			System.out.println("1 - Yes, clear my basket");
			System.out.println("2 - No, take me back");
			System.out.println(formatter());

			switch (in.getNumber("")) {
			case 1:
				basket.clearBasket();
				System.out.println("Your basket has been cleared.");
				mainMenu();
				break;
			case 2:
				viewBasket();
				break;

			}
		} else {
			System.out.println("There are currently no tickets in your basket");
			viewBasket();
		}
	}

}