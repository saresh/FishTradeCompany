package com.saresh.bionic.bean;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("msgs")
@Scope("session")
public class MessageBean implements Serializable {	
	
	private static final long serialVersionUID = -5911304136669153674L;
	
	private final String regFieldRequired = "This field is required";
	private final String regUsernameInvalid = "From 4 to 30 characters, only letters and numbers";
	private final String regPasswordInvalid = "From 4 to 40 characters";
	private final String regNameInvalid = "Up to 40 characters, only letters";
	private final String regSurnameInvalid = "Up to 40 characters, only letters";
	private final String regEmailInvalid = "Email is invalid";
	private final String regTelephoneInvalid = "Up to 18 characters, only numbers and symbols + - ( )";
	private final String dateFormatInvalid = "Wrong date format. Use dd.MM.yyyy";
	
	private final String fishQuantityInvalid = "At list 1 ton, maximum is quantity";
	private final String fishQuantityBoughtInvalid = "Invalid quantity, please enter quantity in tons";
	private final String fishPriceBoughtInvalid = "Invalid price, please enter price for ton in dollars";
	
	private final String customerPrepaymentTypeInvalid = "Input prapayment percent (0 - 100) for customer";
	
	
	public String getRegUsernameInvalid() {
		return regUsernameInvalid;
	}
	public String getRegPasswordInvalid() {
		return regPasswordInvalid;
	}
	public String getRegNameInvalid() {
		return regNameInvalid;
	}
	public String getRegSurnameInvalid() {
		return regSurnameInvalid;
	}
	public String getRegEmailInvalid() {
		return regEmailInvalid;
	}
	public String getRegTelephoneInvalid() {
		return regTelephoneInvalid;
	}
	
	public String getRegFieldRequired() {
		return regFieldRequired;
	}
	public String getFishQuantityInvalid() {
		return fishQuantityInvalid;
	}
	public String getFishQuantityBoughtInvalid() {
		return fishQuantityBoughtInvalid;
	}
	public String getFishPriceBoughtInvalid() {
		return fishPriceBoughtInvalid;
	}
	public String getCustomerPrepaymentTypeInvalid() {
		return customerPrepaymentTypeInvalid;
	}
	public String getDateFormatInvalid() {
		return dateFormatInvalid;
	}
	
	

}
