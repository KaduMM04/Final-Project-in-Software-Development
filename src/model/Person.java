package model;

import java.util.Objects;

public abstract class Person {
	
	private Integer cpf;
	private String name;
	private String email;
	
	public Person(Integer cpf, String name, String email) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return cpf + ", " + name + ", " + email ;
	}
	
	
}
