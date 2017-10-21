package se.adopi.edu.konditori.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.jpa.entities.JPAEmployee;

@Stateless
public class JPAEmployeeFacade extends AbstractFacade<JPAEmployee> {
	@PersistenceContext(unitName="konditori")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public JPAEmployeeFacade() {
		super(JPAEmployee.class);
	}
}
