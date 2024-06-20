package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lawyer extends Person{
	
	private String oab;
	private String preacticArea;
	private List<Case> cases = new ArrayList<>();
	
	public Lawyer(Integer cpf, String name, String email, String oab, String preacticArea, List<Case> cases) {
		super(cpf, name, email);
		this.oab = oab;
		this.preacticArea = preacticArea;
		this.cases = cases;
	}

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		this.oab = oab;
	}

	public String getPreacticArea() {
		return preacticArea;
	}

	public void setPreacticArea(String preacticArea) {
		this.preacticArea = preacticArea;
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
		return super.toString() + oab + ", " + preacticArea;
	}
	
	public static Lawyer fromString(String line, List<String> lines) {
		
		String[] lawyerData = line.split(", ");
		
		Integer cpf = Integer.parseInt(lawyerData[0]);
		String name = (lawyerData[1]);
		String email = (lawyerData[2]);
		String oab = (lawyerData[3]);
		String praticeArea  = (lawyerData[4]);
		
		List<Case> cases = new ArrayList<>();
		for(String caseLines : lines) {
			cases.add(Case.fromString(caseLines, null, null));
		}
		
		return new Lawyer(cpf, name, email, oab, praticeArea, cases);
		
	}
}
