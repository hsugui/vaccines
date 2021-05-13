package com.zup.orange.vaccines.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.orange.vaccines.controller.dto.VaxImmunizationDto;
import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;
import com.zup.orange.vaccines.repository.VaxImmunizationRepository;

@Service
public class VaxImmunizationService {

//	private final UserRepository userRepository;
//	private final VaccinationRepository vaccinationRepository;
//	
//	@Autowired
//	public VaxImmunizationService(UserRepository userRepository, VaccinationRepository vaccinationRepository) {
//		this.userRepository = userRepository;
//		this.vaccinationRepository = vaccinationRepository;
//	}
	
	private final VaxImmunizationRepository vaxImmunizationRepository;
	
	@Autowired
	public VaxImmunizationService(VaxImmunizationRepository vaxImmunizationRepository) {
		this.vaxImmunizationRepository = vaxImmunizationRepository;
	}
	
	public List<VaxImmunizationDto> getVaxImmunization() {
		List<VaxImmunization> vaxImmunizations = vaxImmunizationRepository.findAll();
		return VaxImmunizationDto.convert(vaxImmunizations);
	}
	
	public VaxImmunization addNewVaxImmunization(VaxImmunizationForm vaxImmunizationForm) {
		VaxImmunization vaxImmunization = vaxImmunizationForm.convert();
		return vaxImmunizationRepository.save(vaxImmunization);
	}
	
}
