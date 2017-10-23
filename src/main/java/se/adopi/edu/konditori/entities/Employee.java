package se.adopi.edu.konditori.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeid;

	/*
	 * Jag undviker att använda "name" som kolumnnamn i databaser, används
	 * som keyword i vissa SQL-implementationer
	 */
	@Column(name="fullname", nullable = false, length = 50)
	private String name;

	@Column
	private float salary;

	public Employee() {}
	public Employee(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}

	public int getEmployeeId() { return employeeid; }
	public void setEmployeeId(int employeeId) { this.employeeid = employeeId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public float getSalary() { return salary; }
	public void setSalary(float salary) { this.salary = salary; }

	public float getEmployersFeeRate() {
		return 0.3142f;
	}
	public float getUnionFeeRate() {
		return 0.051f;
	}
	public float getEmployersFee() {
		return getSalary() * getEmployersFeeRate();
	}
	public float getUnionFee() {
		return getSalary() * getUnionFeeRate();
	}
}
