package com.zup.orange.vaccines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.orange.vaccines.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
