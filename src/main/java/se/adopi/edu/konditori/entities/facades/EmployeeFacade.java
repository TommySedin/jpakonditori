package se.adopi.edu.konditori.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.entities.Employee;

@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> {
	@PersistenceContext(unitName="konditori")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EmployeeFacade() {
		super(Employee.class);
	}
}
