package com.rodrigues.funds.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigues.funds.api.dto.ManagerDto;
import com.rodrigues.funds.api.form.ManagerForm;
import com.rodrigues.funds.api.model.Manager;
import com.rodrigues.funds.api.service.ManagerService;

@RestController
@RequestMapping("/v1/managers")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping
	public ResponseEntity<ManagerDto> createManager (@Valid @RequestBody ManagerForm managerForm, UriComponentsBuilder uriBuilder) {
		
		Manager manager = managerService.createManager(managerForm);
		
		URI uri = uriBuilder.path("/v1/managers/{id}").buildAndExpand(manager.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ManagerDto(manager));
	}

}
