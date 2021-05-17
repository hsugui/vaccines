package com.zup.orange.vaccines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.orange.vaccines.model.VaxImmunization;

public interface VaxImmunizationRepository extends JpaRepository<VaxImmunization, Long> {
	
}
