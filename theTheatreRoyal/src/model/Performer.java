package model;

public class Performer {
	private String name;
	private int performerID;
	private boolean isMusic;
	
	public Performer (String name, int performerID, boolean isMusic) {
		this.name = name;
		this.performerID = performerID;
		this.isMusic = isMusic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPerformerID() {
		return performerID;
	}

	public void setPerformerID(int performerID) {
		this.performerID = performerID;
	}

	public boolean isMusic() {
		return isMusic;
	}

	public void setMusic(boolean isMusic) {
		this.isMusic = isMusic;
	}
	
}


