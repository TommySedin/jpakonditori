package se.adopi.edu.konditori.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.adopi.edu.konditori.entities.Ingredient;

@Stateless
public class IngredientFacade extends AbstractFacade<Ingredient> {
	@PersistenceContext(unitName="konditori")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public IngredientFacade() {
		super(Ingredient.class);
	}
}
