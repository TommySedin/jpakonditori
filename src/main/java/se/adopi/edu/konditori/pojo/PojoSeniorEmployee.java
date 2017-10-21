package se.adopi.edu.konditori.pojo;

public class PojoSeniorEmployee extends PojoEmployee {

	public PojoSeniorEmployee(String name, float salary) {
		super(name, salary);
	}

	@Override
	public float getEmployersFeeRate() {
		return 0.1636f;
	}

}
