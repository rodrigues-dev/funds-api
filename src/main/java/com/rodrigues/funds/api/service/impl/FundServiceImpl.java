package com.rodrigues.funds.api.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

	@Autowired
	private FundRepository fundRepository;
	
	@Override
	@Transactional
	public Fund createFund(FundForm fundForm) {
		
		Fund fund = fundRepository.save(fundForm.convertToEntity());
		
		return fund;
	}

	@Override
	@Transactional
	public Optional<Fund> updateFund(FundToUpdateForm fund, Long id) {
		
		Optional<Fund> fundUpdated = fundRepository.findById(id);
		if (fundUpdated.isPresent()) {
			Fund fundToUpdate = fundRepository.getOne(id);
			fundToUpdate.setDateUpdate(Date.valueOf(LocalDate.now()));
			fundToUpdate.setName(fund.getName());
//			fundToUpdate.setManager(manager);
			return fundUpdated;
		}
		
		return null;
	}

	@Override
	public Optional<Fund> getFund(Long id) {
		return fundRepository.findById(id);
	}
	
	@Override
	public List<Fund> getAllFunds() {
		return fundRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteFund(Long id) {
		
		Optional<Fund> fund = fundRepository.findById(id);
		
		if (fund.isPresent()) {
			fundRepository.delete(fund.get());
			return true;
		}
			
		return false;
	}

}
