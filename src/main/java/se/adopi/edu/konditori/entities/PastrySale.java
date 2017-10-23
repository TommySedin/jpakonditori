package se.adopi.edu.konditori.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PastrySale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saleid;

	@ManyToOne
	@JoinColumn(name="pastryid", referencedColumnName="pastryid", nullable=false)
	private Pastry pastry;

	@Column
	private int amount;

	public int getSaleId() { return saleid; }
	public void setSaleId(int saleid) { this.saleid = saleid; }
	public Pastry getPastry() { return pastry; }
	public void setPastry(Pastry pastry) { this.pastry = pastry; }
	public int getAmount() { return amount; }
	public void setAmount(int amount) { this.amount = amount; }
}
