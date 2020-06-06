package com.rodrigues.funds.api.form;

import com.rodrigues.funds.api.model.Manager;

public class FundToUpdateForm {
	
	private String name;
	private Manager manager;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
