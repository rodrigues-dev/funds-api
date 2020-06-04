package com.rodrigues.funds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigues.funds.api.model.Fund;

public interface FundRepository extends JpaRepository<Fund, Long> {

}
