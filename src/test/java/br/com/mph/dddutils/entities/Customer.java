package br.com.mph.dddutils.entities;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.flunt4j.validations.Contract;
import br.com.mph.flunt4j.validations.contracts.Validatable;

public class Customer extends BusinessObject implements Validatable {
	
	private String firstName;
	
	private String lastName;

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void validate() {
		addNotifications(new Contract()
	            .HasMaxLen(firstName, 40, "firstName", "Name should have no more than 40 chars")
	            .HasMinLen(lastName, 3, "lastName", "Name should have at least 3 chars")
	        );
	}

	

}
