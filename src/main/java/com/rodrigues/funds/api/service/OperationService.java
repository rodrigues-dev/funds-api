package com.rodrigues.funds.api.service;

import java.util.List;
import java.util.Optional;

import com.rodrigues.funds.api.form.OperationForm;
import com.rodrigues.funds.api.model.Operation;

public interface OperationService {

	public Operation createOperation(OperationForm operation);

//	public Optional<Operation> updateOperation();
	
	public Optional<Operation> getOperation (Long id);
	
	public List<Operation> getAllOperations ();
	
	public boolean deleteOperation (Long id);

}
