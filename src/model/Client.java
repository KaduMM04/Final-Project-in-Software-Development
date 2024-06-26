package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends Person{

	private String cpf;
	private String cep;
	private List<Case> cases;
	
	public Client() {
		
	}
	
	public Client(String cpf, String name, String email, String cep) {
		super(name, email);
		this.cpf = cpf;
		this.cep = cep;
		cases = new ArrayList<>();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public void addCase(Case c) throws IllegalArgumentException {
		
		if (c == null) {
			throw new IllegalArgumentException("Case cannot be null");
		}
		if (cases.contains(c)) {
			throw new IllegalArgumentException("Case already exists.");
		}
		
		cases.add(c);
		c.setClient(this);
	}
	
	public void removeCase(int searchId) throws IllegalArgumentException{
		
		Case caseToRemove = null;
		
		for (Case temp : cases) {
			if(temp.getId().equals(searchId)) {
				caseToRemove = temp;
				break;
			}
			
		}
		
		if (caseToRemove != null) {
			
			cases.remove(caseToRemove);
			
		} else {
			
			throw new IllegalArgumentException("Case with ID " + searchId + "not found.");
			
		}
		
	}
	
	public List<Case> getAllCases(){
		return cases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.ClientString()).append(", ")
			.append(cpf).append(", ")
			.append(cep).append("\n")
			.append("Cases: \n");
		
		for (Case c : cases) {
			sb.append("\t").append(c.ClientString()).append("\n");
		}
		
		return sb.toString();
	}
	
	public static Client fromString(String line) {
		
	    String[] clientData = line.split(", ");
	    
	    String cpf = clientData[0];
	    String name = clientData[1];
	    String email = clientData[2];
	    String cep = clientData[3];
	    
	    return new Client(cpf, name, email, cep);
	}
}
