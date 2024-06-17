package model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person{

	private String cep;
	private List<Case> cases = new ArrayList<>();
	
	public Client(Integer cpf, String name, String email, String cep, List<Case> cases) {
		super(cpf, name, email);
		this.cep = cep;
		this.cases = cases;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	@Override
	public String toString() {
		return "Client " + super.toString()  
				+ cep + ", " 
				+ cases;
	}
	
	

}
