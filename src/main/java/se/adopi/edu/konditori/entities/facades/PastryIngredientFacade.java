package se.adopi.edu.konditori.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.entities.PastryIngredient;

@Stateless
public class PastryIngredientFacade extends AbstractFacade<PastryIngredient> {
	@PersistenceContext(unitName="konditori")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PastryIngredientFacade() {
		super(PastryIngredient.class);
	}
}
