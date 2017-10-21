package se.adopi.edu.konditori;

public interface Employee {
	public String getName();
	public float getSalary();
	public float getEmployersFeeRate();
	public float getUnionFeeRate();
	public default float getEmployersFee() {
		return getSalary() * getEmployersFeeRate();
	}
	public default float getUnionFee() {
		return getSalary() * getUnionFeeRate();
	}	
}
