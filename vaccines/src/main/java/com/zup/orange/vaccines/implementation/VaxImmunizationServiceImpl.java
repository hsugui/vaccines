package com.zup.orange.vaccines.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.orange.vaccines.controller.dto.VaxImmunizationDto;
import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;
import com.zup.orange.vaccines.repository.VaxImmunizationRepository;
import com.zup.orange.vaccines.service.VaxImmunizationService;

@Service
public class VaxImmunizationServiceImpl implements VaxImmunizationService {
	
	//@Autowired
	private final VaxImmunizationRepository vaxImmunizationRepository;
	
	@Autowired
	public VaxImmunizationServiceImpl(VaxImmunizationRepository vaxImmunizationRepository) {
		this.vaxImmunizationRepository = vaxImmunizationRepository;
	}

//	@Override
//	public List<VaxImmunizationDto> listAllImmunizations() {
//		List<VaxImmunizationDto> dtos = new ArrayList<>();
//		List<VaxImmunization> immunizations = vaxImmunizationRepository.findAll();
//		immunizations.forEach(immunization -> dtos.add(new VaxImmunizationDto(immunization.getUserCpf(), immunization.getVaccineName(), LocalDate.now())));
//		return dtos;
//	}
	
	@Override
	public List<VaxImmunizationDto> listAllImmunizations() {
		List<VaxImmunization> vaxImmunizations = vaxImmunizationRepository.findAll();
		return VaxImmunizationDto.convert(vaxImmunizations);
	}

	@Override
	public VaxImmunization addNewImmunization(VaxImmunizationForm vaxImmunizationForm) {
		VaxImmunization vaxImmunization = vaxImmunizationForm.convert();
		return vaxImmunizationRepository.save(vaxImmunization);
	}




	

	
}
