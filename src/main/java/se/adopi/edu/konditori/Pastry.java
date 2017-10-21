package se.adopi.edu.konditori;

import java.util.List;

public interface Pastry {
	public interface Ingredient {
		public String getName();
		public float getPricePerUnit();
	}
	public class IngredientContent {
		private Ingredient ingredient;
		private float units;
		public IngredientContent(Ingredient i, float units) {
			this.ingredient = i;
			this.units = units;
		}
		public Ingredient getIngredient() { return ingredient; }
		public float getUnits() { return units; }
	}

	public String getName();
	public List<IngredientContent> getIngredients();
	public float getSellPrice();

	public default float costToProduce() {
		float result = 0;
		List<IngredientContent> ingredients = getIngredients();
		for (IngredientContent i : ingredients) {
			result += i.getIngredient().getPricePerUnit() * i.getUnits();
		}
		return result;
	}
}
