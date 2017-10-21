package se.adopi.edu.konditori.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import se.adopi.edu.konditori.Pastry;
import se.adopi.edu.konditori.SoldPastry;
import se.adopi.edu.konditori.jpa.JPAEmployeeFacade;
import se.adopi.edu.konditori.jpa.entities.JPAEmployee;

@Named
@ViewScoped
public class BakeryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private JPAEmployeeFacade employeeEJB;
	private List<JPAEmployee> employees;


	@Inject
	private List<Pastry> pastryTypes;
	private List<SoldPastry> soldPastries;	
	private SoldPastry selectedPastry;


	public List<SoldPastry> getSoldPastries() {
		if (soldPastries == null) {
			soldPastries = new ArrayList<>();
			for (Pastry p : pastryTypes) {
				soldPastries.add(new SoldPastry(p, (int) (Math.random() * 10)));
			}
		}
		return soldPastries;
	}

	public float getSumSoldPastries() {
		float sum = 0;
		for (SoldPastry sp : soldPastries) {
			sum += sp.getUnits() * sp.getPastry().getSellPrice();
		}
		return sum;
	}

	public SoldPastry getSelectedPastry() {
		return selectedPastry;
	}
	public void setSelectedPastry(SoldPastry selectedPastry) {
		this.selectedPastry = selectedPastry;
	}


	public List<JPAEmployee> getEmployees() {
		if (employees == null) {
			employees = employeeEJB.findAll();
		}
		return employees;
	}
	
	public void newEmployee() {
		JPAEmployee e = new JPAEmployee("", 0);
		employeeEJB.create(e);
		employees.add(e);
	}
	public void saveEmployee(JPAEmployee e) {
		employeeEJB.edit(e);
	}
	
	public float getSumSalaries() {
		float result = 0;
		for (JPAEmployee e : getEmployees()) {
			result += e.getSalary();
		}
		return result;
	}
	public float getSumEmployersFees() {
		float result = 0;
		for (JPAEmployee e : getEmployees()) {
			result += e.getEmployersFee();
		}
		return result;
	}
	public float getSumUnionFees() {
		float result = 0;
		for (JPAEmployee e : getEmployees()) {
			result += e.getUnionFee();
		}
		return result;
	}
	public float getTotalEmployeeCosts() {
		return getSumSalaries() + getSumEmployersFees() + getSumUnionFees();  
	}
}
