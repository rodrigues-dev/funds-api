package com.rodrigues.funds.api.form;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.model.Manager;
import com.rodrigues.funds.api.model.Operation;

public class FundForm {

	@NotNull @NotEmpty
	private String name;
	@NotNull @NotEmpty
	@Length(min = 6)
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

	public Fund convertToEntity() {

		Fund fund = new Fund();

		fund.setName(this.name);
		fund.setTicker(this.ticker);
		fund.setCnpj(this.cnpj);
		fund.setDatePurchase(Date.from(Instant.now()));

		return fund;
	}

}
