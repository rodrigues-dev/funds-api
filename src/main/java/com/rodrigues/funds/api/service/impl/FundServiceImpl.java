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

import com.rodrigues.funds.api.form.FundForm;
import com.rodrigues.funds.api.form.FundToUpdateForm;
import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.repository.FundRepository;
import com.rodrigues.funds.api.service.FundService;

@Service
public class FundServiceImpl implements FundService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FundServiceImpl.class);
	
	@Autowired
	private FundRepository fundRepository;
	
	@Override
	@Transactional
	public Fund createFund(FundForm fundForm) {
		LOGGER.info("Creating a new fund resource. Name: " + fundForm.getName());
		return fundRepository.save(fundForm.convertToEntity());
	}

	@Override
	@Transactional
	public Optional<Fund> updateFund(FundToUpdateForm fundForm, Long id) {
		LOGGER.info("Updating fund resource. Id: " + id);
		Optional<Fund> fund = fundRepository.findById(id);
		
		if (fund.isPresent()) {
			Fund fundToUpdate = fundRepository.getOne(id);
			fundToUpdate.setName(fundForm.getName() != null ? fundForm.getName() : fund.get().getName());
			fundToUpdate.setTicker(fundForm.getTicker() != null ? fundForm.getTicker() : fund.get().getTicker());
			fundToUpdate.setCnpj(fundForm.getCnpj() != null ? fundForm.getCnpj() : fund.get().getCnpj());
			fundToUpdate.setOperations(fundForm.getOperations() != null ? fundForm.getOperations() : fund.get().getOperations());
			fundToUpdate.setManager(fundForm.getManager() != null ? fundForm.getManager() : fund.get().getManager());
			fundToUpdate.setDateUpdate(Date.from(Instant.now()));
			
			return fund;
		}
		
		return null;
	}

	@Override
	public Optional<Fund> getFund(Long id) {
		LOGGER.info("Getting fund resource. Id: " + id);
		return fundRepository.findById(id);
	}
	
	@Override
	public List<Fund> getAllFunds() {
		LOGGER.info("Getting a list of funds resource.");
		return fundRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteFund(Long id) {
		LOGGER.info("Deleting fund resource. Id: " + id);
		Optional<Fund> fund = fundRepository.findById(id);
		
		if (fund.isPresent()) {
			fundRepository.delete(fund.get());
			return true;
		}
			
		return false;
	}

}
