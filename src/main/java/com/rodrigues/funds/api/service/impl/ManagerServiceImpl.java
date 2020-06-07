package com.rodrigues.funds.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigues.funds.api.dto.ManagerDto;
import com.rodrigues.funds.api.form.ManagerForm;
import com.rodrigues.funds.api.form.ManagerToUpdateForm;
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
	@Transactional
	public Optional<Manager> updateManager(ManagerToUpdateForm managerForm, Long id) {
		
		Optional<Manager> managerUpdated = managerRepository.findById(id);
		
		if (managerUpdated.isPresent()) {
			Manager manager = managerRepository.getOne(id);
			manager.setName(managerForm.getName());
			manager.setSite(managerForm.getSite());
			return managerUpdated;
		}		
		
		return managerUpdated;
	}

	@Override
	public Optional<Manager> getManager(Long id) {
		return managerRepository.findById(id);
	}
	
	@Override
	public List<ManagerDto> getAllManager() {
		List<Manager> managers = managerRepository.findAll();
		return new ManagerDto().list(managers);
	}

	@Override
	@Transactional
	public boolean deleteManager(Long id) {
		
		if (managerRepository.findById(id).isPresent()) {
			managerRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
