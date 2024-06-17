package model;

public class Secretary extends Person{
	
	private Integer registrationNum;

	public Secretary(Integer cpf, String name, String email, Integer registrationNum) {
		super(cpf, name, email);
		this.registrationNum = registrationNum;
	}

	public Integer getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(Integer registrationNum) {
		this.registrationNum = registrationNum;
	}

	@Override
	public String toString() {
		return "Secretary" 
				+ "\nRegistration number: " + registrationNum 
				+ super.toString();
	}
	
	

}
