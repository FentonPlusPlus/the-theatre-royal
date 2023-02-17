package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStamp {
	private static final SimpleDateFormat dateTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// this method may not be needed
	public static Timestamp getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	public String toString() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dateTimeStamp.format(timestamp);
		return timestamp.toString();
	}
	
}
