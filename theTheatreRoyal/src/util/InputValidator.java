package util;

public class InputValidator {

	public InputValidator() {
		
	}
	
	public Boolean validateCreditCard(String ccNo) {
		if (ccNo.length() != 16) {
			return false;
		} else {
			// luhn algorithm
			// convert input to int
			int[] ccNoInt = new int[ccNo.length()];
			
			for (int i = 0; i < ccNo.length(); i++) {
				ccNoInt[i] = Integer.parseInt(ccNo.substring(i, i + 1));
			}
			// starting from right, double each other digit, if greater than 9 mod 10 and + 1 to the remainder
			for (int i = ccNoInt.length - 2; i >= 0; i = i - 2) {
				int tempValue = ccNoInt[i];
				tempValue = tempValue * 2;
				if (tempValue >9) {
					tempValue = tempValue % 10 + 1;
				}
				ccNoInt[i] = tempValue;
			}
			// Add up all digits
			int total = 0;
			for (int i = 0; i < ccNoInt.length; i++) {
				total += ccNoInt[i];
			}
			// If number is a multiple of 10, it is valid
			if (total % 10 == 0) {
				return true;
			}
			else
			{
				return false;
			}
		}
	}
}
