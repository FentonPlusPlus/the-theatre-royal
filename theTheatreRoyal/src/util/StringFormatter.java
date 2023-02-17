package util;

import java.text.DecimalFormat;

public class StringFormatter {
	DecimalFormat df;

	public StringFormatter() {
		df = new DecimalFormat("0.00");
		
	}
	
	// allows us to format the price
	public String formatPrice(Double price) {
		return "£" + df.format(price);
	}
	
	// allows us to format the duration from the sql data duration
	public String formatDuration(int duration) {
		int h = duration / 60;
		int m = duration % 60;
		String formattedDuration = String.format("%02d:%02d",h,m);
		return formattedDuration;
	}
	
	// returns a string to say that the show has live music.
	// not currently implemented
	public void formatMusicShow(boolean hasMusic) {
		if (hasMusic = true) {
			System.out.println("with live music accompaniment.");
		} else {
			System.out.println("");
		}
	}
	
	public String formatDiscount(double discount) {
		return "-" + discount + "%";
	}
}



