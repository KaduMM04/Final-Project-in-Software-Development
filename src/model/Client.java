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
	
	public void addCase(Case c) {
		cases.add(c);
	}

	@Override
	public String toString() {
		return  super.toString()  
				+ cep + ", " 
				+ cases;
	}
	
	public static Client fromString(String line, List<String> lines) {
		
		String[] clientData = line.split(", ");
		
		Integer cpf = Integer.parseInt(clientData[0]);
		String name = clientData[1];
		String email = clientData[2];
		String cep = clientData[3];
		
		List<Case> cases = new ArrayList<>();
		for(String caseLines : lines) {
			cases.add(Case.fromString(caseLines, null, null));	
		}
		
		return new Client(cpf, name, email, cep, cases);
	}
}
