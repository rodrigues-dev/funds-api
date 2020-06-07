package com.rodrigues.funds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigues.funds.api.dto.ManagerDto;
import com.rodrigues.funds.api.form.ManagerForm;
import com.rodrigues.funds.api.model.Manager;
import com.rodrigues.funds.api.repository.ManagerRepository;
import com.rodrigues.funds.api.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Override
	@Transactional
	public Manager createManager(ManagerForm managerForm) {
		return managerRepository.save(managerForm.convertToEntity());
	}

	@Override
	public ManagerDto updateManager(ManagerForm managerForm) {
		managerRepository.getOne(null);
		return null;
	}

	@Override
	public ManagerDto getManager(Long id) {
		managerRepository.findById(id);
		return null;
	}
	
	@Override
	public List<ManagerDto> getAllManager() {
		List<Manager> managers = managerRepository.findAll();
		return new ManagerDto().list(managers);
	}

	@Override
	public ManagerDto deleteManager(Long id) {
		managerRepository.deleteById(id);
		return null;
	}
	
	
}
