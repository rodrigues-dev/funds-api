package com.rodrigues.funds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigues.funds.api.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
