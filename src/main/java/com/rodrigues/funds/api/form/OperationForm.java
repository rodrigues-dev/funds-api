package com.rodrigues.funds.api.form;

import java.sql.Date;
import java.time.Instant;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.rodrigues.funds.api.enums.Type;
import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.model.Operation;

public class OperationForm {

//	@NotNull @NotEmpty
	private Fund fund;

	@NotNull
	private Type type;
	
	@NotNull
	private int quantity;

	@NotNull @DecimalMin("0.0")
	private double price;

	private double priceTax;

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceTax() {
		return priceTax;
	}

	public void setPriceTax(double priceTax) {
		this.priceTax = priceTax;
	}

	public Operation convertToEntity() {
		
		Operation operation = new Operation();
		
		operation.setFund(this.fund);
		operation.setType(this.type);
		operation.setQuantity(this.quantity);
		operation.setDate(Date.from(Instant.now()));
		operation.setPrice(this.price);
		operation.setPriceTax(this.priceTax);
		
		return operation;
	}

}
