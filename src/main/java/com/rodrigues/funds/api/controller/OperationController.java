package com.rodrigues.funds.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<OperationDto> getOperation (@PathVariable Long id) {
	
		Optional<Operation> operation = operationService.getOperation(id);
		
		if (operation.isPresent())
			return ResponseEntity.ok().body(new OperationDto(operation.get()));
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<OperationDto>> getAllOperations () {
		return ResponseEntity.ok().body(new OperationDto().list(operationService.getAllOperations()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOperation (@PathVariable Long id) {
		
		if (operationService.deleteOperation(id))
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
	
}
