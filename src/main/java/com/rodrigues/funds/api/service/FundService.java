package com.rodrigues.funds.api.service;

import java.util.List;
import java.util.Optional;

import com.rodrigues.funds.api.form.FundForm;
import com.rodrigues.funds.api.model.Fund;

public interface FundService {
	
	public Fund createFund (FundForm fund);
	
	public Fund updateFund (FundForm fund);
	
	public Optional<Fund> getFund (Long id);
	
	public List<Fund> getAllFunds ();
	
	public boolean deleteFund (Long id);

}
