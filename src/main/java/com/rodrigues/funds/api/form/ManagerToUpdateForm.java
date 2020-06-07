package com.rodrigues.funds.api.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ManagerToUpdateForm {

	@NotNull @NotEmpty
	private String name;
	private String site;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
}
