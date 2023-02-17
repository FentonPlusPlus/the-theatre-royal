package util;

public enum Concessions {
	Discounted(0.75), 
	Standard(1.00); 
	
	public final double concessionApplied;
	
	Concessions(double concessionApplied) {
		this.concessionApplied = concessionApplied;
	}
}
