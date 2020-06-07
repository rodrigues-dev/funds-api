package com.rodrigues.funds.api.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.model.Manager;

public class ManagerDto {

	private String name;
	private String cnpj;
	private String site;
	private Date dateUpdate;
	private List<Fund> funds;

	public ManagerDto() {

	}

	public ManagerDto (Manager manager) {
		this.name = manager.getName();
		this.cnpj = manager.getCnpj();
		this.site = manager.getSite() != null ? manager.getSite() : null;
		this.dateUpdate = manager.getDateUpdate();
		this.funds = manager.getFunds() != null ? manager.getFunds() : null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	public List<ManagerDto> list(List<Manager> managers) {
		return managers.stream().map(ManagerDto::new).collect(Collectors.toList());
	}

}
