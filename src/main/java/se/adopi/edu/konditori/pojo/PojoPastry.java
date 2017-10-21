package se.adopi.edu.konditori.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import se.adopi.edu.konditori.Pastry;

public class PojoPastry implements Pastry {
	private String name;
	private float sellPrice;
	private List<IngredientContent> ingredients;

	private PojoPastry(String name, float sellPrice, IngredientContent... ingredients) {
		this.name = name;
		this.sellPrice = sellPrice;
		this.ingredients = new ArrayList<>(Arrays.asList(ingredients));
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public float getSellPrice() {
		return sellPrice;
	}

	@Override
	public List<IngredientContent> getIngredients() {
		return ingredients;
	}

	public static List<Pastry> getPastries() {
		List<Pastry> result = new ArrayList<>();

		PojoIngredient flour = new PojoIngredient("Vetemjöl", 5f);
		PojoIngredient egg = new PojoIngredient("Ägg", 0.5f);
		PojoIngredient sugar = new PojoIngredient("Socker", 2f);
		PojoIngredient milk = new PojoIngredient("Mjölk", 5f);

		result.add(new PojoPastry("Kanelbulle", 20,
						new IngredientContent(flour, 0.2f),
						new IngredientContent(sugar, 0.15f),
						new IngredientContent(milk, 0.1f),
						new IngredientContent(egg, 0.1f)));
		result.add(new PojoPastry("Sockerkaka", 10,
						new IngredientContent(flour, 0.15f),
						new IngredientContent(sugar, 0.15f),
						new IngredientContent(milk, 0.1f),
						new IngredientContent(egg, 0.2f)));
		result.add(new PojoPastry("Punschrulle", 15,
						new IngredientContent(flour, 0.1f),
						new IngredientContent(sugar, 0.15f),
						new IngredientContent(milk, 0.05f),
						new IngredientContent(egg, 0.1f)));
		
		return result;
	}
}
