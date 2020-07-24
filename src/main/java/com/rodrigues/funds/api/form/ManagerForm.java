package com.rodrigues.funds.api.form;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.model.Manager;

public class ManagerForm {
	
	@NotNull @NotEmpty
	private String name;
	@NotNull @NotEmpty @Length(max = 14, min = 14)
	private String cnpj;
	private String site;
	private Date dateUpdate;
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
	
	public Manager convertToEntity () {
		Manager manager = new Manager();
		manager.setName(this.name); 
		manager.setCnpj(this.cnpj);
		manager.setSite(this.site !=null ? this.site : null);
		manager.setFunds(this.funds != null ? this.funds : null);
		manager.setDateUpdate(Date.from(Instant.now()));
		
		return manager;
	}

}
