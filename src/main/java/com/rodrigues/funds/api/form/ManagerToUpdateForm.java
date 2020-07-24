package com.rodrigues.funds.api.form;

import java.util.List;

import com.rodrigues.funds.api.model.Fund;

public class ManagerToUpdateForm {
	
	private String name;
	private String cnpj;
	private String site;
	private List<Fund> funds;
	
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
	public List<Fund> getFunds() {
		return funds;
	}
	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}
	
}
