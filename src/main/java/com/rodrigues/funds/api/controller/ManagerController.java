package com.rodrigues.funds.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigues.funds.api.dto.ManagerDto;
import com.rodrigues.funds.api.form.ManagerForm;
import com.rodrigues.funds.api.form.ManagerToUpdateForm;
import com.rodrigues.funds.api.model.Manager;
import com.rodrigues.funds.api.service.ManagerService;

@RestController
@RequestMapping("/v1/managers")
public class ManagerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping
	public ResponseEntity<ManagerDto> createManager (@Valid @RequestBody ManagerForm managerForm, UriComponentsBuilder uriBuilder) {
		
		Manager manager = managerService.createManager(managerForm);
		
		URI uri = uriBuilder.path("/v1/managers/{id}")
				.buildAndExpand(manager.getId())
				.toUri();
		
		LOGGER.info("Created a new manager. Id: " + manager.getId());
		return ResponseEntity.created(uri).body(new ManagerDto(manager));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateManager (@RequestBody ManagerToUpdateForm managerForm, @PathVariable Long id) {
		
		Optional<Manager> manager = managerService.updateManager(managerForm, id);
		
		if (manager.isPresent()) {
			LOGGER.info("Manager " + id + " updated");
			return ResponseEntity.ok(new ManagerDto(manager.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ManagerDto>> getAllManagers () {
		LOGGER.info("Listing managers");
		return ResponseEntity.ok(managerService.getAllManager());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getManager (@PathVariable Long id) {
		
		Optional<Manager> manager = managerService.getManager(id);
		
		if (manager.isPresent()) {
			LOGGER.info("Manager " + id + " finded");
			return ResponseEntity.ok(new ManagerDto(manager.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManager (@PathVariable Long id){
		
		if (managerService.deleteManager(id)) {
			LOGGER.info("Manager " + id + " deleted");
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
