package br.com.mph.dddutils.entities;

import br.com.mph.dddutils.BusinessObject;
import br.com.mph.flunt4j.validations.Contract;
import br.com.mph.flunt4j.validations.contracts.Validatable;

public class Order extends BusinessObject implements Validatable {
	
	private Integer number;
	
	private Customer customer;		

	public Order(Integer number, Customer customer) {
		super();
		this.number = number;
		this.customer = customer;
	}

	public Integer getNumber() {
		return number;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void validate() {
		super.validate();
		addNotifications(new Contract()
				.isNotNull(number, "number", "Number is mandatory")
				.isNotNull(customer, "customer", "Customer is mandatory"));
	}

}
