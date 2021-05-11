package com.zup.orange.vaccines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.orange.vaccines.model.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

}
