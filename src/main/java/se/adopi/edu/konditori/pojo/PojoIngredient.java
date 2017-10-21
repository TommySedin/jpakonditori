package se.adopi.edu.konditori.pojo;

import se.adopi.edu.konditori.Pastry.Ingredient;

public class PojoIngredient implements Ingredient {
	private String name;
	private float ppu;

	public PojoIngredient(String name, float ppu) {
		this.name = name;
		this.ppu = ppu;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getPricePerUnit() {
		return ppu;
	}
}
