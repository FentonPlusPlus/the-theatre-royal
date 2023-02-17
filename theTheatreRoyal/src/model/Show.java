package model;

import java.util.ArrayList;

public class Show {
	private int productionID;
	private String showName;
	private String showType;
	private String showDescription;
	private int duration;
	private boolean liveAccompaniment;
	private double stallsPrice;
	private double circlePrice;
	private ArrayList<Performer> performers;

	public Show() {
		super();
		this.productionID = 0;
		this.showName = null;
		this.showType = null;
		this.showDescription = null;
		this.duration = 0;
		this.liveAccompaniment = false;
		this.stallsPrice = 0;
		this.circlePrice = 0;
		performers = new ArrayList<Performer>();
	}

	public int getProductionID() {
		return productionID;
	}

	public void setProductionID(int productionID) {
		this.productionID = productionID;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getShowDescription() {
		return showDescription;
	}

	public void setShowDescription(String showDescription) {
		this.showDescription = showDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isLiveAccompaniment() {
		return liveAccompaniment;
	}

	public void setLiveAccompaniment(boolean liveAccompaniment) {
		this.liveAccompaniment = liveAccompaniment;
	}

	public double getStallsPrice() {
		return stallsPrice;
	}

	public void setStallsPrice(double stallsPrice) {
		this.stallsPrice = stallsPrice;
	}

	public double getCirclePrice() {
		return circlePrice;
	}

	public void setCirclePrice(double circlePrice) {
		this.circlePrice = circlePrice;
	}

	/**
	 * methods for ArrayList performers getAllPerformers, addPerformer,
	 * getMusicPerformers, getRegularPerformers
	 * 
	 */

	public ArrayList<Performer> getAllPerformers() {
		return performers;
	}

	public void addPerformer(Performer performer) {
		performers.add(performer);
	}

	public ArrayList<Performer> getMusicPerformers() {
		ArrayList<Performer> musicPerformers = new ArrayList<Performer>();
		for (int i = 0; i < performers.size(); i++) {
			if (performers.get(i).isMusic()) {
				musicPerformers.add(performers.get(i));
			}
		}

		return musicPerformers;
	}

	public ArrayList<Performer> getRegularPerformers() {
		ArrayList<Performer> regularPerformers = new ArrayList<Performer>();
		for (int i = 0; i < performers.size(); i++) {
			if (performers.get(i).isMusic()) {
				regularPerformers.add(performers.get(i));
			}
		}

		return regularPerformers;
	}

}
