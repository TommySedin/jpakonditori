package se.adopi.edu.konditori;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import se.adopi.edu.konditori.pojo.PojoEmployee;
import se.adopi.edu.konditori.pojo.PojoPastry;

@ApplicationScoped
public class Configuration {
	@Produces
	public List<Pastry> getPastries() {
		//TODO: Kolla om vi ska returnera Pojos eller JPA-entities
		return PojoPastry.getPastries();
	}
	@Produces
	public List<Employee> getEmployees() {
		//TODO: Kolla om vi ska returnera Pojos eller JPA-entities
		return PojoEmployee.getEmployees();
	}
}
