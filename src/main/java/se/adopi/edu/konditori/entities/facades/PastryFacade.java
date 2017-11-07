package se.adopi.edu.konditori.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.entities.Pastry;

@Stateless
public class PastryFacade extends AbstractFacade<Pastry> {
	@PersistenceContext(unitName="konditori")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PastryFacade() {
		super(Pastry.class);
	}
}
