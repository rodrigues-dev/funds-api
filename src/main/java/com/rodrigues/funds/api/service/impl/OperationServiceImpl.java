package com.rodrigues.funds.api.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigues.funds.api.form.OperationForm;
import com.rodrigues.funds.api.model.Operation;
import com.rodrigues.funds.api.repository.OperationRepository;
import com.rodrigues.funds.api.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	@Transactional
	public Operation createOperation(OperationForm operationForm) {
		
		Operation operation = operationRepository.save(operationForm.convertToEntity());
		
		return operation;
	}

	@Override
	public Optional<Operation> getOperation(Long id) {
		return operationRepository.findById(id);
	}

	@Override
	public List<Operation> getAllOperations() {
		return operationRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteOperation(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
