package com.rodrigues.funds.api.service.impl;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	@Transactional
	public Manager createManager(ManagerForm managerForm) {
		LOGGER.info("Creating a new manager resource. Name: " + managerForm.getName());
		return managerRepository.save(managerForm.convertToEntity());
	}

	@Override
	@Transactional
	public Optional<Manager> updateManager(ManagerToUpdateForm managerForm, Long id) {
		LOGGER.info("Updating manager resource. Id: " + id);
		Optional<Manager> manager = managerRepository.findById(id);
		
		if (manager.isPresent()) {
			Manager managerToUpdate = managerRepository.getOne(id);
			managerToUpdate.setName(managerForm.getName() != null ? managerForm.getName() : manager.get().getName());
			managerToUpdate.setCnpj(managerForm.getCnpj() != null ? managerForm.getCnpj() : manager.get().getCnpj());
			managerToUpdate.setSite(managerForm.getSite() != null ? managerForm.getSite() : manager.get().getSite());
			managerToUpdate.setFunds(managerForm.getFunds() != null ? managerForm.getFunds() : manager.get().getFunds());
			managerToUpdate.setDateUpdate(Date.from(Instant.now()));
			
			return manager;
		}		
		
		return manager;
	}

	@Override
	public Optional<Manager> getManager(Long id) {
		LOGGER.info("Getting manager resource. Id: " + id);
		return managerRepository.findById(id);
	}
	
	@Override
	public List<ManagerDto> getAllManager() {
		LOGGER.info("Getting a list of managers resource.");
		List<Manager> managers = managerRepository.findAll();
		return new ManagerDto().list(managers);
	}

	@Override
	@Transactional
	public boolean deleteManager(Long id) {
		LOGGER.info("Deleting manager resource. Id: " + id);
		if (managerRepository.findById(id).isPresent()) {
			managerRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
