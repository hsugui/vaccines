package com.zup.orange.vaccines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.orange.vaccines.controller.dto.VaccinationDto;
import com.zup.orange.vaccines.controller.form.VaccinationForm;
import com.zup.orange.vaccines.model.Vaccination;
import com.zup.orange.vaccines.repository.VaccinationRepository;

@Service
public class VaccinationService {

	private final VaccinationRepository vaccinationRepository;
	
	@Autowired
	public VaccinationService(VaccinationRepository vaccinationRepository) {
		this.vaccinationRepository = vaccinationRepository;
	}
	
	public List<VaccinationDto> getVaccinations() {
		List<Vaccination> vaccinations = vaccinationRepository.findAll();
		return VaccinationDto.convert(vaccinations);
	}

	public void addNewVax(VaccinationForm vaccinationForm) {
		Vaccination vaccination = vaccinationForm.convert();
		vaccinationRepository.save(vaccination);
	}
	
}
