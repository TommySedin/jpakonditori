package se.adopi.edu.konditori.entities.facades;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.entities.Employee;

@Stateless
@DeclareRoles({"admin","employee"})
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

	@Override
	@RolesAllowed("admin")
	public void create(Employee entity) { super.create(entity); }
}
