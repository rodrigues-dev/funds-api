package com.rodrigues.funds.api.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.rodrigues.funds.api.enums.Type;
import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.model.Operation;

public class OperationDto {

	private Fund fund;
	
	private Type type;
	
	private int quantity;
	
	private Date date;
	
	private double price;
	
	private double priceTax;
	
	public OperationDto() {
		
	}
	
	public OperationDto(Operation operation) {
		this.fund = operation.getFund() != null ? operation.getFund() : null;
		this.type = operation.getType();
		this.quantity = operation.getQuantity();
		this.date = operation.getDate();
		this.price = operation.getPrice();
		this.priceTax = operation.getPriceTax();
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	public List<OperationDto> list (List<Operation> operations){
		return operations.stream().map(OperationDto::new).collect(Collectors.toList());
	}

}
