package util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringFormatterTest {
	private StringFormatter sf = new StringFormatter();

	@Test
	void formatPriceTest() {
		assertEquals("£4.00", sf.formatPrice(4.00));
		assertEquals("£12.99", sf.formatPrice(12.99));
		assertEquals("£9.50", sf.formatPrice(9.50));
		assertEquals("£10.03", sf.formatPrice(10.034538297483785235));
		
	}
	@Test
	void formatDurationTest() {
		assertEquals("02:00", sf.formatDuration(120));
		assertEquals("01:21", sf.formatDuration(81));
		assertEquals("24:03", sf.formatDuration(1443));
	}
	
	@Test
	void formatDiscountTest() {
		assertEquals("-25.0%", sf.formatDiscount(25));
		assertEquals("-99.0%", sf.formatDiscount(99));
	}
}
//	
//	@Test(expected = AssertionError.class) 
//	void formatPriceErrorTest() {
//		assertEquals("£9.500", sf.formatPrice(9.50));
//
//	}
//}
