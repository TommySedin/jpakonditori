package se.adopi.edu.konditori.entities;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pastry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pastryid;

	@Column(name="pastryname", nullable = false, length = 50)
	private String name;

	@Column
	private float sellprice;

	@OneToMany(mappedBy="pastry")
	private List<PastryIngredient> ingredients;
	
	public int getPastryId() { return pastryid; }
	public void setPastryId(int pastryId) { this.pastryid = pastryId; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public float getSellPrice() { return sellprice; }
	public void setSellPrice(float sellprice) { this.sellprice = sellprice; }
	public List<PastryIngredient> getIngredients() { return ingredients; }
	public void setIngredients(List<PastryIngredient> ingredients) { this.ingredients = ingredients; }
	public float getBakeCost() {
		float result = 0;
		for (PastryIngredient i : getIngredients()) {
			result += i.getAmount() * i.getIngredient().getPricePerUnit();
		}
		return result;
	}

	@Override
	public boolean equals(Object other) {
	    return (other instanceof Pastry) && (pastryid != 0)
	        ? pastryid == (((Pastry) other).pastryid)
	        : (other == this);
	}

	@Override
	public int hashCode() {
	    return (pastryid != 0)
	        ? (this.getClass().hashCode() + pastryid)
	        : super.hashCode();
	}
}
