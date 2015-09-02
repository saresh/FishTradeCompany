package com.saresh.bionic.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.saresh.bionic.entity.Customer;
import com.saresh.bionic.service.CustomerService;

@Named
@Scope("session")
public class ManageCustomersBean implements Serializable {
	
	private static final long serialVersionUID = -8391538156529311511L;

	private List<Customer> customersList = null;
	
	private Customer customerToEdit;
	
	@Inject
	CustomerService customerService;
	
	public void updateCustomersList(){
		customersList = customerService.findAll();
	}
	
	public String editCustomer(Customer customer){
		customerToEdit = customer;
		return "/gm/editCustomerPT";
	}
	
	public String updateCustomer(){
		customerService.save(customerToEdit);
		return "/gm/manageCustomers";
	}

	public List<Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(List<Customer> customersList) {
		this.customersList = customersList;
	}

	public Customer getCustomerToEdit() {
		return customerToEdit;
	}

	public void setCustomerToEdit(Customer customerToEdit) {
		this.customerToEdit = customerToEdit;
	}

}
