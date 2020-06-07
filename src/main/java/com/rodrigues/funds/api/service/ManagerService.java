package com.rodrigues.funds.api.service;

import com.rodrigues.funds.api.dto.ManagerDto;
import com.rodrigues.funds.api.form.ManagerForm;
import com.rodrigues.funds.api.model.Manager;

public interface ManagerService {

	public Manager createManager (ManagerForm managerForm);
	
	public ManagerDto updateManager (ManagerForm managerForm);
	
	public ManagerDto getManager (Long id);
	
	public ManagerDto deleteManager (Long id);
	
}
