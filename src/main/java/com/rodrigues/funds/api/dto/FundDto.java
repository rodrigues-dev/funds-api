package com.rodrigues.funds.api.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.model.Manager;
import com.rodrigues.funds.api.model.Operation;

public class FundDto {
	
	private String name;
	private String ticker;
	private Long cnpj;
	private List<Operation> operations;
	private Manager manager;
	private Date datePurchase;
	private Date dateUpdate;
	
	public FundDto() {
		
	}
	
	public FundDto(Fund fund) {
		this.name = fund.getName();
		this.ticker = fund.getTicker();
		this.cnpj = fund.getCnpj();
		this.datePurchase = fund.getDatePurchase();
		this.dateUpdate = fund.getDateUpdate() != null ? fund.getDateUpdate() : null;
		this.manager = fund.getManager() != null ? fund.getManager() : null;
		this.operations = fund.getOperations() != null ? fund.getOperations() : null;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

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

	public List<FundDto> list (List<Fund> funds) {
		return funds.stream().map(FundDto::new).collect(Collectors.toList());
	}
}
