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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigues.funds.api.dto.FundDto;
import com.rodrigues.funds.api.form.FundForm;
import com.rodrigues.funds.api.form.FundToUpdateForm;
import com.rodrigues.funds.api.model.Fund;
import com.rodrigues.funds.api.service.FundService;

@RestController
@RequestMapping("/v1/funds")
public class FundController {

	@Autowired
	private FundService fundService;
	
	@PostMapping
	public ResponseEntity<FundDto> createFund (@Validated @RequestBody FundForm fundForm, UriComponentsBuilder uriBuilder) {
		
		Fund fund = fundService.createFund(fundForm);
		
		URI uri = uriBuilder.path("/v1/funds/{id}")
				.buildAndExpand(fund.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new FundDto(fund));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FundDto> updateFund (@RequestBody FundToUpdateForm fundForm, @PathVariable Long id) {
		
		Optional<Fund> fundUpdated = fundService.updateFund(fundForm, id);
		
		if (fundUpdated.isPresent())
			return ResponseEntity.ok(new FundDto(fundUpdated.get()));
		
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FundDto> getFund (@PathVariable Long id) {
		
		Optional<Fund> fund = fundService.getFund(id);
		
		if (fund.isPresent())
			return ResponseEntity.ok(new FundDto(fund.get()));
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<FundDto>> getAllFunds () {
		return ResponseEntity.ok(new FundDto().list(fundService.getAllFunds()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFund (@PathVariable Long id) {
		
		if (fundService.deleteFund(id))
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
	
}
