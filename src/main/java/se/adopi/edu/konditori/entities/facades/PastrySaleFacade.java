package se.adopi.edu.konditori.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.entities.PastrySale;

@Stateless
public class PastrySaleFacade extends AbstractFacade<PastrySale> {
	@PersistenceContext(unitName="konditori")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PastrySaleFacade() {
		super(PastrySale.class);
	}
}
