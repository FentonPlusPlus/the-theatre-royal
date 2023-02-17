package model;

public class Performance {
	private int productionID;
	private int performanceID;
	private String date;
	private String startTime;
	private int circleAvailable;
	private int stallsAvailable;

	public Performance() {
		this.productionID = 0;
		this.performanceID = 0;
		this.date = null;
		this.startTime = null;
		circleAvailable = 0;
		stallsAvailable = 0;
	}

	public int getProductionID() {
		return productionID;
	}

	public void setProductionID(int productionID) {
		this.productionID = productionID;
	}

	public int getPerformanceID() {
		return performanceID;
	}

	public void setPerformanceID(int performanceID) {
		this.performanceID = performanceID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getCircleAvailable() {
		return circleAvailable;
	}

	public int getStallsAvailable() {
		return stallsAvailable;
	}

	/**
	 * methods below represent the availability of seats change when an int
	 * parameter is passed. This int parameter represents the amount of tickets
	 * purchased by the User.
	 * 
	 */
	public void setCircleAvailable(int purchase) {
		this.circleAvailable = purchase;
	}

	public void setStallsAvailable(int purchase) {
		this.stallsAvailable = purchase;
	}

}
