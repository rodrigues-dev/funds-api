package com.rodrigues.funds.api.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigues.funds.api.form.OperationForm;
import com.rodrigues.funds.api.model.Operation;
import com.rodrigues.funds.api.repository.OperationRepository;
import com.rodrigues.funds.api.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationServiceImpl.class);
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	@Transactional
	public Operation createOperation(OperationForm operationForm) {
		LOGGER.info("Creating a new operation resource. Type: " + operationForm.getType());
		return operationRepository.save(operationForm.convertToEntity());
	}

	@Override
	public Optional<Operation> getOperation(Long id) {
		LOGGER.info("Getting operation resource. Id: " + id);
		return operationRepository.findById(id);
	}

	@Override
	public List<Operation> getAllOperations() {
		LOGGER.info("Getting a list of operations resource.");
		return operationRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteOperation(Long id) {
		LOGGER.info("Deleting operation resource. Id: " + id);
		Optional<Operation> operation = operationRepository.findById(id);
		
		if (operation.isPresent()) {
			operationRepository.delete(operation.get());
			return true;
		}
		
		return false;
	}

}
