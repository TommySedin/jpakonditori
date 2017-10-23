package se.adopi.edu.konditori.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredientid;

	@Column(name="ingredientname", nullable = false, length = 50)
	private String name;

	@Column(name="unitprice")
	private float pricePerUnit;

	@OneToMany(mappedBy="ingredient")
	private List<PastryIngredient> ingredients;

	public int getIngredientId() { return ingredientid; }
	public void setIngredientId(int ingredientId) { this.ingredientid = ingredientId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public float getPricePerUnit() { return pricePerUnit; }
	public void setPricePerUnit(float pricePerUnit) { this.pricePerUnit = pricePerUnit; }
}
