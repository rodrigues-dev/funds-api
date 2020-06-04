package com.rodrigues.funds.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigues.funds.api.form.FundForm;
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
	public Fund updateFund(FundForm fund) {
		
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
	public void deleteFund(Long id) {
		
	}

}
