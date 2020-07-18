package com.rodrigues.funds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigues.funds.api.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
