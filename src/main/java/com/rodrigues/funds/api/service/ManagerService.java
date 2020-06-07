package com.rodrigues.funds.api.service;

import java.util.List;
import java.util.Optional;

import com.rodrigues.funds.api.dto.ManagerDto;
import com.rodrigues.funds.api.form.ManagerForm;
import com.rodrigues.funds.api.model.Manager;

public interface ManagerService {

	public Manager createManager (ManagerForm managerForm);
	
	public ManagerDto updateManager (ManagerForm managerForm);
	
	public Optional<Manager> getManager(Long id);
	
	public List<ManagerDto> getAllManager();
	
	public boolean deleteManager(Long id);
	
}
