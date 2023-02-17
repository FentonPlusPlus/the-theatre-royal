package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTest {

	@Test
	void Concessionstest() {
	Ticket ticket1 = new Ticket();
	ticket1.setPrice(10.00);
	assertEquals(10.00, ticket1.getPrice());
	ticket1.applyConcession();
	assertEquals(7.50, ticket1.getPrice());
	}

}
