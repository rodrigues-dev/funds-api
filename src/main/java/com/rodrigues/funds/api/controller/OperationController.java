package com.rodrigues.funds.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigues.funds.api.dto.OperationDto;
import com.rodrigues.funds.api.form.OperationForm;
import com.rodrigues.funds.api.model.Operation;
import com.rodrigues.funds.api.service.OperationService;

@RestController
@RequestMapping("v1/operations")
public class OperationController {

	@Autowired
	private OperationService operationService;
	
	@PostMapping
	public ResponseEntity<OperationDto> createOperation (@Validated @RequestBody OperationForm operationForm, UriComponentsBuilder uriBuilder) {
		
		Operation operation = operationService.createOperation(operationForm);
		
		URI uri = uriBuilder.path("v1/operatios/{id}")
				.buildAndExpand(operation.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new OperationDto(operation));
	}
	
	@GetMapping("/{id}")
	public void getOperation (@PathVariable Long id) {
		
	}
	
	@GetMapping
	public void getAllOperations () {
		
	}
	
	@PutMapping
	public void updateOperation () {
		
	}
	
	@DeleteMapping
	public void deleteOperation () {
		
	}
	
}
