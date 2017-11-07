package se.adopi.edu.konditori.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PastryIngredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contentid;

	@ManyToOne
	@JoinColumn(name="pastryid", referencedColumnName="pastryid", nullable=false)
	private Pastry pastry;

	@ManyToOne
	@JoinColumn(name="ingredientid", referencedColumnName="ingredientid", nullable=false)
	private Ingredient ingredient;

	@Column
	private float amount;

	public int getContentId() { return contentid; }
	public void setContentId(int contentId) { this.contentid = contentId; }
	public Pastry getPastry() { return pastry; }
	public void setPastry(Pastry newpastry) {
		if (this.pastry != null) {
			this.pastry.getIngredients().remove(this);
		}
		this.pastry = newpastry;
		if (!this.pastry.getIngredients().contains(this)) {
			this.pastry.getIngredients().add(this);
		}
	}
	public Ingredient getIngredient() { return ingredient; }
	public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }
	public float getAmount() { return amount; }
	public void setAmount(float amount) { this.amount = amount; }
}







	
	
	