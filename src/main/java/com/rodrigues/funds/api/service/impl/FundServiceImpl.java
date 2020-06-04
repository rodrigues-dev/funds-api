package com.rodrigues.funds.api.service.impl;

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
	public Fund getFund(Long id) {
		
		return null;
	}
	
	@Override
	public Fund getAllFunds() {
		
		return null;
	}

	@Override
	public void deleteFund(Long id) {
		
	}

}
