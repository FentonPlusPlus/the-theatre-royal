package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasketTest {

	Basket basket = new Basket();
	
	@Test
	void basketTotalAndClearBasketTest() {
		Ticket ticket1 = new Ticket();
		ticket1.setPrice(10.00);
		Ticket ticket2 = new Ticket();
		ticket2.setPrice(5.01);
		assertEquals(10.00, ticket1.getPrice());
		assertEquals(5.01, ticket2.getPrice());
		Basket basket = new Basket();
		assertFalse(basket.getPostage());
		basket.addTicket(ticket1);
		basket.addTicket(ticket2);
		assertEquals(15.01, basket.getBasketTotal());
		Ticket ticket3 = new Ticket();
		ticket3.setPrice(19.03);
		basket.addTicket(ticket3);
		assertEquals(34.04, basket.getBasketTotal());
		basket.clearBasket();
		assertEquals(0, basket.getNoOfTotalTickets());
		assertEquals(0.00, basket.getBasketTotal());
	}
}