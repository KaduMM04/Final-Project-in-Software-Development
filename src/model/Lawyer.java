package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lawyer extends Person{
	
	private String oab;
	private String practiceArea;
	private List<Case> cases;
	
	public Lawyer() {
		
	}
	
	public Lawyer(String name, String email, String password, String oab, String practiceArea) {
		super(name, email, password);
		this.oab = oab;
		this.practiceArea = practiceArea;
		cases = new ArrayList<>();
	}

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		this.oab = oab;
	}

	public String getPreacticeArea() {
		return practiceArea;
	}

	public void setPracticArea(String practiceArea) {
		this.practiceArea = practiceArea;
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
		c.setLawyer(this);
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
		result = prime * result + Objects.hash(oab);
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
		Lawyer other = (Lawyer) obj;
		return Objects.equals(oab, other.oab);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.UserString()).append(", ")
			.append(oab).append(", ")
			.append(practiceArea).append("\n")
			.append("Cases: \n");
		
		for (Case c : cases) {
			sb.append("\t").append(c.toString()).append("\n");
		}
		
		return sb.toString();
	}
	
	
	public static Lawyer fromString(String line) {
		
	  String[] lawyerData = line.split(", ");
	    
	  String name = lawyerData[0];
	  String email = lawyerData[1];
	  String password = lawyerData[2];
	  String oab = lawyerData[3];
	  String practiceArea = lawyerData[4];
	  
	  return new Lawyer(name, email, password, oab, practiceArea);
	   
	}
}
