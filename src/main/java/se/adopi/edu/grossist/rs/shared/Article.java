package se.adopi.edu.grossist.rs.shared;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Denna klass borde egentligen ligga i ett separat projekt som "grossisten" tillhandahåller till "konditoriet".
 */

@XmlRootElement
public class Article {
	@XmlElement
	private String name;
	@XmlElement
	private float costPerUnit;
	@XmlElement
	private String unit;

	public Article() {}
	public Article(String name, float costPerUnit, String unit) {
		this.name = name;
		this.costPerUnit = costPerUnit;
		this.unit = unit;
	}

	public String getName() { return name; }
	public float getCostPerUnit() { return costPerUnit; }
	public String getUnit() { return unit; }
}
