package se.adopi.edu.konditori.backing;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import se.adopi.edu.konditori.entities.Employee;
import se.adopi.edu.konditori.entities.Pastry;
import se.adopi.edu.konditori.entities.PastrySale;
import se.adopi.edu.konditori.entities.facades.EmployeeFacade;
import se.adopi.edu.konditori.entities.facades.PastryFacade;
import se.adopi.edu.konditori.entities.facades.PastrySaleFacade;

@Named
@ViewScoped
public class BakeryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB private EmployeeFacade employeeEJB;
	@EJB private PastryFacade pastryEJB;
	@EJB private PastrySaleFacade saleEJB;

	private List<Employee> employees;
	private List<PastrySale> sales;	


	public List<PastrySale> getSales() {
		if (sales == null) {
			sales = saleEJB.findAll();
		}
		return sales;
	}
	public void newSale() {
		PastrySale s = new PastrySale();
		s.setPastry(pastryEJB.find(1)); //Default to first pastry
		saleEJB.create(s);
		sales.add(s);
	}
	public void saveSale(PastrySale s) {
		saleEJB.edit(s);
	}
	public List<Pastry> getPastries() {
		return pastryEJB.findAll();
	}

	public float getSumSoldPastries() {
		float sum = 0;
		for (PastrySale ps : getSales()) {
			if (ps.getPastry() != null) {
				sum += ps.getAmount() * ps.getPastry().getSellPrice();
			}
		}
		return sum;
	}


	public List<Employee> getEmployees() {
		if (employees == null) {
			employees = employeeEJB.findAll();
		}
		return employees;
	}
	
	public void newEmployee() {
		Employee e = new Employee("", 0);
		employeeEJB.create(e);
		employees.add(e);
	}
	public void saveEmployee(Employee e) {
		employeeEJB.edit(e);
	}
	
	public float getSumSalaries() {
		float result = 0;
		for (Employee e : getEmployees()) {
			result += e.getSalary();
		}
		return result;
	}
	public float getSumEmployersFees() {
		float result = 0;
		for (Employee e : getEmployees()) {
			result += e.getEmployersFee();
		}
		return result;
	}
	public float getSumUnionFees() {
		float result = 0;
		for (Employee e : getEmployees()) {
			result += e.getUnionFee();
		}
		return result;
	}
	public float getTotalEmployeeCosts() {
		return getSumSalaries() + getSumEmployersFees() + getSumUnionFees();  
	}

	public PastryFacade getPastryEJB() { return pastryEJB; }
}
