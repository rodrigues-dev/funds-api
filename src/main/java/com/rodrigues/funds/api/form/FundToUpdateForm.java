package com.rodrigues.funds.api.form;

import java.util.List;

import com.rodrigues.funds.api.model.Manager;
import com.rodrigues.funds.api.model.Operation;

public class FundToUpdateForm {
	
	private String name;
	private String ticker;
	private Long cnpj;
	private List<Operation> operations;
	private Manager manager;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
}
