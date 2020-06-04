package com.rodrigues.funds.api.service;

import com.rodrigues.funds.api.form.FundForm;
import com.rodrigues.funds.api.model.Fund;

public interface FundService {
	
	public Fund createFund (FundForm fund);
	
	public Fund updateFund (FundForm fund);
	
	public Fund getFund (Long id);
	
	public Fund getAllFunds ();
	
	public void deleteFund (Long id);

}
