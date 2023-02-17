package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

	@Test
	void validateCreditCardtest() {
		InputValidator iv = new InputValidator();
		// valid and false credit cards
		assertTrue(iv.validateCreditCard("4916822022785622"));
		assertFalse(iv.validateCreditCard("4916822022785623"));
		assertTrue(iv.validateCreditCard("2221001476588733"));
		assertFalse(iv.validateCreditCard("5528567799674628"));
		// characters too long
		assertFalse(iv.validateCreditCard("55285677996746288"));
		assertFalse(iv.validateCreditCard("552856779967462"));
	}

}
