package se.adopi.edu.konditori;

public class SoldPastry {
	private Pastry pastry;
	private int units;
	public SoldPastry(Pastry pastry, int units) {
		this.pastry = pastry;
		this.units = units;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public Pastry getPastry() {
		return pastry;
	}
}
