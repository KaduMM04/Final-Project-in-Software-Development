package model;

import java.util.Objects;

public class Case {
	
	private Integer id;
	private String typeCase;
	private Client client;
	private Lawyer lawyer;
	private String description;
	private Double price;
	
	public Case(Integer id, String typeCase, Client client, Lawyer lawyer, String description, Double price) {
		this.id = id;
		this.typeCase = typeCase;
		this.client = client;
		this.lawyer = lawyer;
		this.description = description;
		this.price = price;
		
		this.client.addCase(this);
		this.lawyer.addCase(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeCase() {
		return typeCase;
	}

	public void setTypeCase(String typeCase) {
		this.typeCase = typeCase;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	public Lawyer getLawyer() {
		return lawyer;
	}

	public void setLawyer(Lawyer lawyer) {
		this.lawyer = lawyer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return  + id + ", " + client.getName()
				+ ", " + typeCase 
				+ ", " + description
				+ ", " + price;
	}
	
	public String ClientString() {
		return  + id + ", " + lawyer.getName()
				+ " (" + lawyer.getOab() + ")"
				+ ", " + typeCase 
				+ ", " + description
				+ ", " + price;
	}
	
	public String showCaseData() {
		return "Case" + id 
				+ "\nClient: " + client.getName()
				+ "\nLawyer: " + lawyer.getName()
				+ "\nType of case:" + typeCase 
				+ "\nDescription: " + description
				+ "\nValue ";
	}
	
	public static Case fromString(String line, Client client, Lawyer lawyer) {
		
		String[] caseData = line.split(", ");
		
		Integer id = Integer.parseInt(caseData[0]);
		String typeCase = (caseData[1]);
		String description = (caseData[2]);
		Double price = Double.parseDouble(caseData[3]);
		
		return new Case(id, typeCase, client, lawyer, description, price);
		
	}
}
