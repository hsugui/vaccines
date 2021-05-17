package com.zup.orange.vaccines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zup.orange.vaccines.model.VaxImmunization;

public interface VaxImmunizationRepository extends JpaRepository<VaxImmunization, Long> {
	
}
